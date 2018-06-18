package json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

public class JsonTest {
	
	/**
	 * 使用jackson api将java对象转换成json字符串
	 * @throws JsonProcessingException 
	 */
	public static void test1() throws JsonProcessingException {
		Stock s=new Stock();
		s.setCode("2333");
		s.setName("BILI");
		s.setPrice(22.33);
		//jackson api
		ObjectMapper om=new ObjectMapper();
		String jsonStr=om.writeValueAsString(s);
		System.out.println(jsonStr);
	}
	public static void test2() throws JsonProcessingException {
		List<Stock> stocks=new ArrayList<Stock>();
		for(int i=0;i<3;i++) {
			Stock s=new Stock();
			s.setCode("2333"+i);
			s.setName("BILI"+i);
			s.setPrice(22.33+i);
			stocks.add(s);
		}
		ObjectMapper om=new ObjectMapper();
		String jsonStr=om.writeValueAsString(stocks);
		System.out.println(jsonStr);
	}
	public static void main(String[] args) throws JsonProcessingException {
		test1();
		test2();
	}
}
