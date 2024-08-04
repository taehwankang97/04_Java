package memberdao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
	 
	private final String FILE_PATH = "io_test/membershio.dat";
	
	private List<Member> memberList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	public MemberDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH)); 
				memberList = (ArrayList<Member>)ois.readObject();
			}finally {
				if(ois != null) ois.close();
			}
		}
		else {
			 memberList = new ArrayList<Member>();
		}
	}
	
	

}
