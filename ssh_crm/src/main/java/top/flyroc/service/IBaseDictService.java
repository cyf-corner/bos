package top.flyroc.service;

import java.util.List;
import top.flyroc.domain.BaseDict;

public interface IBaseDictService {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
