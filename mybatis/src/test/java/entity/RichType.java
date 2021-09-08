package entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/7
 */
@Getter
@Setter
public class RichType {

    private RichType richType;
    private String richField;
    private String richProperty;
    private Map richMap = new HashMap();

    private List<String> richList = new ArrayList<String>() {
        private static final long serialVersionUID = 6928391649401837842L;

        {
            add("小家伙要记得学习");
        }
    };
}
