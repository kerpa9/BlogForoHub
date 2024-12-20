package ForoHub.Blog.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ForoHub.Blog.Domain.DTOs.ProfileDTO;
import ForoHub.Blog.Domain.Models.Profile;
import ForoHub.Blog.Services.ProfileService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody @Valid ProfileDTO profileDTO) {

        Profile createProfile = profileService.createProfile(profileDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createProfile);

    }
}
