    package com.scoutspace.Accommodation.controller;
    
    import com.scoutspace.Accommodation.exception.UserNotFoundException;
    import com.scoutspace.Accommodation.model.User;
    import com.scoutspace.Accommodation.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    
    import java.util.List;
    
    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        private final UserService userService;
    
        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

    
        // Endpoint to create a new user
        @PostMapping("/create")
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }

    
        // Endpoint to get a user by ID
        @GetMapping("/{userId}")
        public ResponseEntity<User> getUserById(@PathVariable Long userId) throws UserNotFoundException {
            User user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        }
    
        // Endpoint to get all users
        @GetMapping("/all")
        public ResponseEntity<List<User>> getAllUsers() {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        }
    
        // Endpoint to delete a user by ID
        @DeleteMapping("/{userId}")
        public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
            userService.deleteUserByUserId(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    
        // Other endpoints can be added as needed (e.g., update user, search users, etc.)
    }