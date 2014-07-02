import java.io.*;
import java.net.*;
import java.util.ArrayList;

import org.json.*;
public class project {

	public static void main(String[] argv) throws IOException, JSONException , NullPointerException {
		try{
		// TODO Auto-generated method stub
		    String url=new String(argv[0]);
			URL myurl = new URL(url);
			URLConnection myconnection = myurl.openConnection();
			myconnection.connect();
			BufferedReader BR = new BufferedReader(new InputStreamReader(myurl.openStream(),"UTF-8"));
			String temp;
			StringBuilder builder = new StringBuilder();
			while ((temp = BR.readLine()) != null)
			{
				builder.append(temp);
				//System.out.println(temp);
			}
	        String json = builder.toString();
			JSONTokener jsontokener = new JSONTokener(json);
			JSONArray jsonarray = new JSONArray(jsontokener);
			ArrayList<String> roadarray = new ArrayList<String>();
			ArrayList<Integer> numinroad = new ArrayList<Integer>();
			int j=0,k=0,l=0;
			float jnum=0,knum=0,lnum=0;
			for(int i=0;i<jsonarray.length();i++)
			{
				
				JSONObject jsonob = jsonarray.getJSONObject(i);
				String temp1 = jsonob.getString("����h��");
				
				
				int price=jsonob.getInt("�`����");
				int area=jsonob.getInt("�ت������`���n���褽��");
				//int compare=jsonob.getInt("����C���褽��");
				
				if(area!=0)
				{
					float compare=price/area;
				if(temp1.equals("�|�h"))
				{
					j=j+1;
					jnum=jnum/j*(j-1)+compare/j;
					
					//System.out.println(temp1);
				}
				else if(temp1.contains("�Q�T�h"))
				{
					k=k+1;
					knum=knum/k*(k-1)+compare/k;
					//System.out.println(temp1);
				}
				else if(temp1.equals("���h")){}
				else 
				{
					l=l+1;
					lnum=lnum/l*(l-1)+compare/l;
					//System.out.println(temp1);
				}
				}
			}
			System.out.println("�|�h:"+j+"   "+jnum);
			System.out.println("�Q�T�h:"+k+"   "+knum);
			System.out.println("��L:"+l+"   "+lnum);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

}

