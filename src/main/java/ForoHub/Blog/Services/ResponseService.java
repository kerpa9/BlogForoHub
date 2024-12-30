package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.ResponseDTO;
import ForoHub.Blog.Domain.Models.Response;
import ForoHub.Blog.Repository.ResponseRepository;
import ForoHub.Blog.Repository.TopicRepository;
import ForoHub.Blog.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository response;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private FilterLoginService filter;

    @Transactional
    public Response createResponse(@Valid ResponseDTO responseDTO) {

        Response responseData = new Response();

        var topic = topicRepository.findById(responseDTO.idTopic()).get();
        var users = usersRepository.findById(responseDTO.idUsers()).get();

        Long userId = filter.getUserLogin();

        Long sequentialResponse = response.generatedInsertSequential(userId) + 1;

        responseData.setId_login(userId);
        responseData.setId_response(sequentialResponse);
        responseData.setTopic(topic);
        responseData.setUsers(users);
        responseData.setMessage(responseDTO.message());
        responseData.setCreate_date(responseDTO.create_date());
        responseData.setSolution(responseDTO.solution());
        responseData.setActive(responseDTO.active());

        return response.save(responseData);

    }

    @Transactional
    public Page<Response> getAllResponse(Pageable pageable) {

        Long loggedUserId = filter.getUserLogin();

        return response.findAllActive(loggedUserId, pageable);
    }

    @Transactional
    public Response getOneByID(Long id) {
        return response.findByIdUserLogin(id, filter.getUserLogin());
    }

    @Transactional
    public void deleteResponse(Long id) {
        Response responseModel = response.findByIdUserLogin(id, filter.getUserLogin());
        responseModel.setStausInactiveResponse();
    }

}
