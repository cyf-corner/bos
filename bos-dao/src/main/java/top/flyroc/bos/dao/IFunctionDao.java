package top.flyroc.bos.dao;

import java.util.List;

import top.flyroc.bos.dao.base.IBaseDao;
import top.flyroc.bos.domain.Function;

public interface IFunctionDao extends IBaseDao<Function> {

	List<Function> findFunctionListByUserId(String id);

	List<Function> findAllMenu();

	List<Function> findMenuByUserId(String id);

}
