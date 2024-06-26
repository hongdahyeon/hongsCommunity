package hongs.community.hongsCommunity.domain.user.after.restcontroller;

import hongs.community.hongsCommunity.domain.user.after.HongUserService;
import hongs.community.hongsCommunity.domain.user.after.dto.HongUserUpdteDto;
import hongs.community.hongsCommunity.domain.user.after.vo.HongUserCheckEmailVo;
import hongs.community.hongsCommunity.domain.user.after.vo.HongUserListVo;
import hongs.community.hongsCommunity.global.hongs.dto.response.ApiDocumentResponse;
import hongs.community.hongsCommunity.global.hongs.dto.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
@Tag(name = "유저 RestController", description = "로그인 이후 접근 가능한 RestController")
public class HongUserRestController {

    private final HongUserService userService;

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\." +
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";

    @GetMapping("/chkUserEmail.json")
    @Operation(summary = "이메일 중복 확인", description = "회원정보 변경시, 이메일 중복 확인")
    @ApiDocumentResponse
    public Response chkUserEmail(HongUserCheckEmailVo checkEmailVo) {
        Map<String, Object> map = new HashMap<>();
        if(isValidEmail(checkEmailVo.getUserEmail())) {
            Integer chkedUserEmail = userService.chkUserEmail(checkEmailVo);
            String message = (chkedUserEmail == 0) ? "사용 가능한 이메일입니다." : "중복되는 이메일입니다. \n 다른 이메일을 입력해주세요.";
            map.put("key", chkedUserEmail); map.put("message", message);
        } else {
            map.put("key", 3); map.put("message", "이메일 형식이 유효하지 않습니다.");
        }
        return Response.ok(map);
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @PutMapping("/update.json")
    @Operation(summary = "회원정보 변경", description = "회원정보 변경하기")
    @ApiDocumentResponse
    public Response update(@RequestBody HongUserUpdteDto dto) {
        userService.updateUser(dto);
        return Response.ok();
    }

    @GetMapping("/list.json")
    @Operation(summary = "회원정보 리스트 조회", description = "회원정보 리스트 조회")
    @ApiDocumentResponse
    public Response list() {
        List<HongUserListVo> list = userService.list();
        return Response.ok(list);
    }
}
