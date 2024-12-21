package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.ResponseDTO;
import ForoHub.Blog.Domain.Models.Response;
import ForoHub.Blog.Repository.ResponseRepository;
import ForoHub.Blog.Repository.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository response;

    @Autowired
    private TopicRepository topicRepository;

    @Transactional
    public Response createResponse(@Valid ResponseDTO responseDTO) {

        Response responseData = new Response();

        var topic = topicRepository.findById(responseDTO.idTopic()).get();

        responseData.setTopic(topic);
        responseData.setMessage(responseDTO.message());
        responseData.setCreate_date(responseDTO.create_date());
        responseData.setSolution(responseDTO.solution());

        return response.save(responseData);

    }

    @Transactional
    public Page<Response> getAllResponse(Pageable pageable) {
        return response.findAll(pageable);
    }

}
