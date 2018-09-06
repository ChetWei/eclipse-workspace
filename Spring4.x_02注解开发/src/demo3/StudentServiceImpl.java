package demo3;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


public class StudentServiceImpl implements StudentService {

	@Resource(name="studentDao")
	private StudentDao studentDao;

	@Override
	public void save() {
		studentDao.save();
	}

}
