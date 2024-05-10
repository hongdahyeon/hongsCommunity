package hongs.community.hongsCommunity.domain.code;

import hongs.community.hongsCommunity.domain.code.dto.HongCodeDeleteDto;
import hongs.community.hongsCommunity.domain.code.dto.HongCodeInsertDto;
import hongs.community.hongsCommunity.domain.code.dto.HongCodeUpdateDto;
import hongs.community.hongsCommunity.domain.code.vo.HongCodeViewVo;
import hongs.community.hongsCommunity.domain.code.vo.HongUpperCodeListVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HongCodeService {

    private final HongCodeMapper hongCodeMapper;

    public List<HongUpperCodeListVo> upperList() {
        return  hongCodeMapper.upperList();
    }

    public Boolean checkIfDuplicate(String codeVal) {
        Integer checkIfDuplicate = hongCodeMapper.checkIfDuplicate(codeVal);
        if(checkIfDuplicate == 0) return false;
        else return true;
    }

    public Integer insert(HongCodeInsertDto dto) {
        return hongCodeMapper.insert(dto);
    }

    public HongCodeViewVo upperView(Long hongCodeUid) {
        return hongCodeMapper.upperView(hongCodeUid);
    }

    public Integer delete(HongCodeDeleteDto dto) {
        return hongCodeMapper.delete(dto);
    }

    public Integer update(HongCodeUpdateDto dto) {
        return hongCodeMapper.update(dto);
    }
}
