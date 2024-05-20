package hongs.community.hongsCommunity.domain.report.restController;


import hongs.community.hongsCommunity.domain.report.HongBoardReportService;
import hongs.community.hongsCommunity.domain.report.dto.HongBoardReportListDto;
import hongs.community.hongsCommunity.domain.report.vo.HongBoardReportListVo;
import hongs.community.hongsCommunity.global.hongs.dto.response.ApiDocumentResponse;
import hongs.community.hongsCommunity.global.hongs.dto.response.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/board/report")
@RequiredArgsConstructor
@Tag(name = "USER 권한 > 게시판 유형별 게시글 보기", description = "USER 권한에서 접근이 가능하며, 게시판 유형별 게시글을 관람한다.")
public class HongBoardReportRestController {

    private final HongBoardReportService boardReportService;

    @GetMapping("/list.json")
    @Operation(summary = "게시글 리스트 조회", description = "게시글 리스트를 조회한다.")
    @ApiDocumentResponse
    public Response list(HongBoardReportListDto dto) {
        List<HongBoardReportListVo> list = boardReportService.list(dto);
        return Response.ok(list);
    }
}
