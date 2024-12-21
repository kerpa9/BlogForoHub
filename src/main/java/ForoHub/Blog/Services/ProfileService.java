package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.ProfileDTO;
import ForoHub.Blog.Domain.Models.Profile;
import ForoHub.Blog.Repository.ProfileRepository;
import ForoHub.Blog.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public Profile createProfile(@Valid ProfileDTO profileDTO) {

        Profile profile = new Profile();

        var user = usersRepository.findById(profileDTO.idUser()).get();
        profile.setName_profile(profileDTO.name_profile());
        profile.setUsers(user);

        return profileRepository.save(profile);

    }

}
