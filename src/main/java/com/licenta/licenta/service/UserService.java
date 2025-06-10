package com.licenta.licenta.service;

import com.licenta.licenta.model.Role;
import com.licenta.licenta.model.User;
import com.licenta.licenta.repository.UserRepository;
import com.licenta.licenta.repository.team_repositories.TeamsSummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TeamsSummaryRepository teamsSummaryRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public User registerUser(String username, String email, String password, Role role, String teamName) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }
        if (role == Role.TEAM_MANAGER && teamName != null && userRepository.existsByAssignedTeam(teamName)) {
            throw new RuntimeException("Team already has a manager");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);

        if (role == Role.TEAM_MANAGER && teamName != null) {
            user.setAssignedTeam(teamName);
        }

        return userRepository.save(user);
    }

    public List<User> getPendingApprovals() {
        return userRepository.findByRoleAndIsApproved(Role.TEAM_MANAGER, false);
    }

    public void approveUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setIsApproved(true);
        userRepository.save(user);
    }

    public void rejectUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public List<String> getAvailableTeams() {
        // Get all Serie A teams from your actual database
        List<String> allTeams = teamsSummaryRepository.findAll()
                .stream()
                .map(team -> team.getSquad())
                .distinct()
                .sorted()
                .toList();

        // Get teams that already have managers assigned
        List<String> takenTeams = userRepository.findByRole(Role.TEAM_MANAGER)
                .stream()
                .map(User::getAssignedTeam)
                .filter(team -> team != null)
                .toList();

        // Return available teams (Serie A teams that don't have managers yet)
        return allTeams.stream()
                .filter(team -> !takenTeams.contains(team))
                .toList();
    }

    public List<String> getAllTeams() {
        // Get all Serie A teams (for dropdowns, lists, etc.)
        return teamsSummaryRepository.findAll()
                .stream()
                .map(team -> team.getSquad())
                .distinct()
                .sorted()
                .toList();
    }

    public List<String> getAllPlayers() {
        // You can create a similar method to get all players
        // This would be useful for search functionality
        // For now, you might want to use one of your player repositories
        // Example: return playersSummaryRepository.findAll().stream().map(player -> player.getPlayer()).distinct().sorted().toList();
        return List.of(); // TODO: Implement based on which player table you want to use
    }
}