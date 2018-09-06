package demo3;

import org.springframework.stereotype.Repository;



public class StudentDaoImpl implements StudentDao {

	@Override
	public void save() {
		System.out.println("save。。。");	
	}

}
