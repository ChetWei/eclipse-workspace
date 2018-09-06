package serviceImpl;

import java.util.List;

import dao.BaseDictDao;
import service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	//对象注入
	private BaseDictDao baseDictDao;
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	
	//根据dict_type_code查找
	@Override
	public List findByTypeCode(String dictTypeCode) {
		return baseDictDao.findByTypeCode(dictTypeCode);
	}
	
}
