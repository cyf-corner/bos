package top.flyroc.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.flyroc.bos.dao.IWorkordermanageDao;
import top.flyroc.bos.domain.Workordermanage;
import top.flyroc.bos.service.IWorkordermanageService;

@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService {

	@Autowired
	private IWorkordermanageDao workordermanageDao;

	public void save(Workordermanage model) {
		workordermanageDao.save(model);
	}
}
