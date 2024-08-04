package memberservice;

import java.io.FileNotFoundException;
import java.io.IOException;

import memberdao.MemberDao;
import memberdao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private MemberDao dao = null;
	
	public MemberServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new MemberDaoImpl();
	}
	
}
