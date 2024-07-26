package alcohol.service;

import java.util.ArrayList;
import java.util.List;

import alcohol.dto.AlcoholDTO;

public class AlcoholService {

	private List<AlcoholDTO> AlcoholList = new ArrayList<AlcoholDTO>(); 
	
	public AlcoholService() {
		AlcoholList.add(new AlcoholDTO("연태고량주", 80, 12000));
		
	}
}
