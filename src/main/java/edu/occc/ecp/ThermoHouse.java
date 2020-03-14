package edu.occc.ecp;

public class ThermoHouse {

	private int TempRoom1;
	private int TempRoom2;
	private int TempRoom3;
	private int EastFacingWindow;

	public ThermoHouse(int TempRoom1, int TempRoom2, int TempRoom3, int EastFacingWindow)
	{

		this.TempRoom1 = TempRoom1;
		this.TempRoom2 = TempRoom2;
		this.TempRoom3 = TempRoom3;
		this.EastFacingWindow = EastFacingWindow;
	}

	public ThermoHouse(ThermoHouse t) {
		TempRoom1 = t.getTempRoom1();
		TempRoom2 = t.getTempRoom2();
		TempRoom3 = t.getTempRoom3();
		EastFacingWindow = t.getEastFacingWindow();

	}

	//
	public int getEastFacingWindow()
	{
		// TODO Auto-generated method stub
		return EastFacingWindow;
	}

	public void setEastFacingWindow(int EastFacingWindow)
	{
		this.EastFacingWindow = EastFacingWindow;
	}

	public int getTempRoom1()
	{
		return TempRoom1;
	}


	public void setTempRoom1(int TempRoom1)
	{
		this.TempRoom1 = TempRoom1;
	}



	public int getTempRoom2()
	{
		return TempRoom2;
	}

	public void setTempRoom2(int TempRoom2)
	{
		this.TempRoom2 = TempRoom2;
	}

	public int getTempRoom3()
	{
		return TempRoom3;
	}

	public void setTempRoom3(int TempRoom3)
	{
		this.TempRoom3 = TempRoom3;
	}

}
