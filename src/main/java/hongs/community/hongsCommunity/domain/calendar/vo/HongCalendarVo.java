package hongs.community.hongsCommunity.domain.calendar.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HongCalendarVo {

    private Long uid;
    private String title;
    private String start;
    private String end;
    private String backgroundColor;
    private String borderColor;
    private String textColor;
    private boolean allDay;
}