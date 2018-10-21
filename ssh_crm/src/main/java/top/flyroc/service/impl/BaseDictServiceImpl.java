package top.flyroc.service.impl;

import java.util.List;
import top.flyroc.dao.IBaseDictDao;
import top.flyroc.domain.BaseDict;
import top.flyroc.service.IBaseDictService;

public class BaseDictServiceImpl implements IBaseDictService {

	private IBaseDictDao baseDictDao;

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return baseDictDao.getListByTypeCode(dict_type_code);
	}

	public void setBaseDictDao(IBaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

}
