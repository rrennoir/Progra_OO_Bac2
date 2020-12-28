package data;

import java.util.ArrayList;

public class Network
{
	private String ipMask;
	private ArrayList<String> ipList;
	private String name;

	Network(String ip, String name)
	{
		this.name = name;
		this.ipMask = ip;
		this.ipList = new ArrayList<String>();
	}

	public int getDeviceCount()
	{
		return this.ipList.size();
	}

	public String getNewIp()
	{
		if (ipList.size() < 254)
		{
			String[] ip = this.ipMask.split("\\.");
			
			int i = 1;
			String tempIp = String.format("%s.%s.%s.%s", ip[0], ip[1], ip[2], i);
			while (this.ipList.contains(tempIp) && i < 254)
			{
				tempIp = String.format("%s.%s.%s.%s", ip[0], ip[1], ip[2], i);
				i++;
			}
			
			this.ipList.add(tempIp);
			return tempIp;
		}
		else
		return "";
	}
	
	public void DelIp(String ip)
	{
		this.ipList.remove(ip);
	}
	
	public String toString()
	{
		return this.name + " a pour masque " + this.ipMask + " et a " + this.getDeviceCount() + " appareils connectés";
	}
}

