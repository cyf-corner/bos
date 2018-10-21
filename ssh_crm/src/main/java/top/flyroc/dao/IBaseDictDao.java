package top.flyroc.dao;

import java.util.List;
import top.flyroc.domain.BaseDict;

public interface IBaseDictDao extends IBaseDao<BaseDict> {

	List<BaseDict> getListByTypeCode(String dict_type_code);

}
