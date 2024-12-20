package ForoHub.Blog.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ForoHub.Blog.Domain.DTOs.ResponseDTO;
import ForoHub.Blog.Domain.Models.Response;
import ForoHub.Blog.Repository.ResponseRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository response;

    @Transactional
    public Response createResponse(@Valid ResponseDTO responseDTO) {
        
        Response responseData = new Response();
        responseData.setMessage(responseDTO.message());
        responseData.setCreate_date(responseDTO.create_date());
        responseData.setSolution(responseDTO.solution());

        return response.save(responseData);

    }

}
