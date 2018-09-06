package daoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import dao.BaseDictDao;
import domain.BaseDict;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {

	//根据dict_type_code查找
	@Override
	public List findByTypeCode(String dictTypeCode) {
		List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict b  where b.dict_type_code = ?0 ", dictTypeCode);
		return list;
	}

}
