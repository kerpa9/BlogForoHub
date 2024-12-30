package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private FilterLoginService filter;

    @Transactional
    public Profile createProfile(@Valid ProfileDTO profileDTO) {

        Profile profile = new Profile();

        Long userId = filter.getUserLogin();

        Long sequentialProfile = profileRepository.generatedInsertSequential(userId) + 1;

        var user = usersRepository.findById(profileDTO.idUser()).get();

        profile.setId_login(userId);
        profile.setId_profile(sequentialProfile);
        profile.setName_profile(profileDTO.name_profile());
        profile.setUsers(user);
        profile.setActive(profileDTO.active());

        return profileRepository.save(profile);

    }

    @Transactional
    public Page<Profile> getAllProfiles(Pageable pageable) {
        return profileRepository.findAllActive(pageable);
    }

}
