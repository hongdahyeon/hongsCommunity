package hongs.community.hongsCommunity.domain.test.dto;

import hongs.community.hongsCommunity.global.hongs.dto.request.FileRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* @fileName TestFileDto
* @author dahyeon
* @version 1.0.0
* @date 2024-03-05
* @summary  test_table 파일 같이 저장 dto
**/
@Getter
@Setter
@ToString
public class TestFileDto extends FileRequest {

    private Long uid;
    private Long fileUid;
    private String name;

}
