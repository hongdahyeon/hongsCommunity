package hongs.community.hongsCommunity.domain.test;

import hongs.community.hongsCommunity.domain.test.dto.TestFileDto;
import hongs.community.hongsCommunity.global.hongs.mail.EmailService;
import hongs.community.hongsCommunity.global.hongs.dto.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/test")
public class TestRestController {

    private final TestService testService;
    private final EmailService emailService;

    @PostMapping("/save.json")
    public Response save(@RequestBody TestFileDto dto) {
        Long fileUid = testService.save(dto);
        return Response.created(fileUid);
    }

    @PutMapping("/edit.json")
    public Response edit(@RequestBody TestFileDto dto) {
        Long fileUid = testService.edit(dto);
        return Response.ok(fileUid);
    }

    @GetMapping("/sendMessage.json")
    public Response sendMessage() {
        emailService.sendTest("julie0427@naver.com");
        return Response.noContent();
    }
}
