package com.ascentcomtec.smarthouse.constant;

import java.util.ArrayList;

import com.ascentcomtec.smarthouse.model.Attribute;
import com.ascentcomtec.smarthouse.model.Cluster;
import com.ascentcomtec.smarthouse.model.DataType;

public class Clusters {

	public static ArrayList<Cluster> clousers = new ArrayList<Cluster>();
	static
	{
		//0x0000
		Cluster c0000 = new Cluster();
		c0000.ID=0x0000;
		c0000.Name="Basic";
		clousers.add(c0000);
		
		//0x0001
		Cluster c0001 = new Cluster();
		c0001.ID=0x0001;
		c0001.Name="Power configuration";
		clousers.add(c0001);
		
		//0x0002
		Cluster c0002 = new Cluster();
		c0002.ID=0x0002;
		c0002.Name="Device TemperatureConfiguration";
		clousers.add(c0002);
		
		//0x0003
		Cluster c0003 = new Cluster();
		c0003.ID=0x0003;
		c0003.Name="Identify";
		clousers.add(c0003);
		
		//0x0004
		Cluster c0004 = new Cluster();
		c0004.ID=0x0004;
		c0004.Name="GroupsGroups";
		clousers.add(c0004);
		
		//0x0005
		Cluster c0005 = new Cluster();
		c0005.ID=0x0005;
		c0005.Name="Scenes";
		clousers.add(c0005);
		
		//0x0006
		Cluster c0006 = new Cluster();
		c0006.ID=0x0006;
		c0006.Name="On/off";
		Attribute attr_1 = new Attribute();
		attr_1.ID=0x0000;
		attr_1.Name="OnOff";
		DataType dt_1 = new DataType();
		dt_1.ID=0x10;
		dt_1.des="Boolean";
		attr_1.dataType=dt_1;
		c0006.AddAttribute(attr_1);
		clousers.add(c0006);
		
		//0x0007
		Cluster c0007 = new Cluster();
		c0007.ID=0x0007;
		c0007.Name="On/off Switch Configuration";
		clousers.add(c0007);
		
		//0x0008
		Cluster c0008 = new Cluster();
		c0008.ID=0x0008;
		c0008.Name="Level Control";
		Attribute attr_2 = new Attribute();
		attr_2.ID=0x0000;
		attr_2.Name="CurrentLevel";
		DataType dt_2 = new DataType();
		dt_2.ID=0x20;
		dt_2.des="Unsigned 8-bit integer";
		attr_2.dataType=dt_2;
		c0008.AddAttribute(attr_2);
		clousers.add(c0008);
		
		//0x0009
		Cluster c0009 = new Cluster();
		c0009.ID=0x0009;
		c0009.Name="Alarms";
		clousers.add(c0009);
		
		//0x000a
		Cluster c000a = new Cluster();
		c000a.ID=0x000a;
		c000a.Name="Time";
		clousers.add(c000a);
		
		//0x000b
		Cluster c000b = new Cluster();
		c000b.ID=0x000b;
		c000b.Name="RSSI Location";
		clousers.add(c000b);
		
		//0x000c
		Cluster c000c = new Cluster();
		c000c.ID=0x000c;
		c000c.Name="Analog Input (Basic)";
		Attribute attr_3 = new Attribute();
		attr_3.ID=0x0055;
		attr_3.Name="PresentValue";
		DataType dt_3 = new DataType();
		dt_3.ID=0x21;
		dt_3.des="Unsigned 16-bit integer";
		attr_3.dataType=dt_3;
		c000c.AddAttribute(attr_3);
		Attribute attr_4 = new Attribute();
		attr_4.ID=0x006f;
		attr_4.Name="StatusFlags";
		DataType dt_4 = new DataType();
		dt_4.ID=0x18;
		dt_4.des="8-bit bitmap";
		attr_4.dataType=dt_4;
		c000c.AddAttribute(attr_4);
		clousers.add(c000c);
		
		//0x000d
		Cluster c000d = new Cluster();
		c000d.ID=0x000d;
		c000d.Name="Analog Output (Basic)";
		Attribute attr_5 = new Attribute();
		attr_5.ID=0x0055;
		attr_5.Name="PresentValue";
		DataType dt_5 = new DataType();
		dt_5.ID=0x21;
		dt_5.des="Unsigned 16-bit integer";
		attr_5.dataType=dt_5;
		c000d.AddAttribute(attr_5);
		Attribute attr_6 = new Attribute();
		attr_6.ID=0x006f;
		attr_6.Name="StatusFlags";
		DataType dt_6 = new DataType();
		dt_6.ID=0x18;
		dt_6.des="8-bit bitmap";
		attr_6.dataType=dt_6;
		c000d.AddAttribute(attr_6);
		clousers.add(c000d);
		
		//0x000e
		Cluster c000e = new Cluster();
		c000e.ID=0x000e;
		c000e.Name="Analog Value (Basic)";
		Attribute attr_7 = new Attribute();
		attr_7.ID=0x0055;
		attr_7.Name="PresentValue";
		DataType dt_7 = new DataType();
		dt_7.ID=0x21;
		dt_7.des="Unsigned 16-bit integer";
		attr_7.dataType=dt_7;
		c000e.AddAttribute(attr_7);
		Attribute attr_8 = new Attribute();
		attr_8.ID=0x006f;
		attr_8.Name="StatusFlags";
		DataType dt_8 = new DataType();
		dt_8.ID=0x18;
		dt_8.des="8-bit bitmap";
		attr_8.dataType=dt_8;
		c000e.AddAttribute(attr_8);
		clousers.add(c000e);
		
		//0x000f
		Cluster c000f = new Cluster();
		c000f.ID=0x000f;
		c000f.Name="Binary Input (Basic)";
		Attribute attr_9 = new Attribute();
		attr_9.ID=0x0055;
		attr_9.Name="PresentValue";
		DataType dt_9 = new DataType();
		dt_9.ID=0x21;
		dt_9.des="Unsigned 16-bit integer";
		attr_9.dataType=dt_9;
		c000f.AddAttribute(attr_9);
		Attribute attr_10 = new Attribute();
		attr_10.ID=0x006f;
		attr_10.Name="StatusFlags";
		DataType dt_10 = new DataType();
		dt_10.ID=0x18;
		dt_10.des="8-bit bitmap";
		attr_10.dataType=dt_10;
		c000f.AddAttribute(attr_10);
		clousers.add(c000f);
		
		//0x0010
		Cluster c0010 = new Cluster();
		c0010.ID=0x0010;
		c0010.Name="Binary Output (Basic)";
		Attribute attr_11 = new Attribute();
		attr_11.ID=0x0055;
		attr_11.Name="PresentValue";
		DataType dt_11 = new DataType();
		dt_11.ID=0x21;
		dt_11.des="Unsigned 16-bit integer";
		attr_11.dataType=dt_11;
		c0010.AddAttribute(attr_11);
		Attribute attr_12 = new Attribute();
		attr_12.ID=0x006f;
		attr_12.Name="StatusFlags";
		DataType dt_12 = new DataType();
		dt_12.ID=0x18;
		dt_12.des="8-bit bitmap";
		attr_12.dataType=dt_12;
		c0010.AddAttribute(attr_12);
		clousers.add(c0010);
		
		//0x0011
		Cluster c0011 = new Cluster();
		c0011.ID=0x0011;
		c0011.Name="Binary Value (Basic)";
		Attribute attr_13 = new Attribute();
		attr_13.ID=0x0055;
		attr_13.Name="PresentValue";
		DataType dt_13 = new DataType();
		dt_13.ID=0x21;
		dt_13.des="Unsigned 16-bit integer";
		attr_13.dataType=dt_13;
		c0011.AddAttribute(attr_13);
		Attribute attr_14 = new Attribute();
		attr_14.ID=0x006f;
		attr_14.Name="StatusFlags";
		DataType dt_14 = new DataType();
		dt_14.ID=0x18;
		dt_14.des="8-bit bitmap";
		attr_14.dataType=dt_14;
		c0011.AddAttribute(attr_14);
		clousers.add(c0011);
		
		//0x0012
		Cluster c0012 = new Cluster();
		c0012.ID=0x0012;
		c0012.Name="Multistate Input (Basic)";
		Attribute attr_15 = new Attribute();
		attr_15.ID=0x0055;
		attr_15.Name="PresentValue";
		DataType dt_15 = new DataType();
		dt_15.ID=0x21;
		dt_15.des="Unsigned 16-bit integer";
		attr_15.dataType=dt_15;
		c0012.AddAttribute(attr_15);
		Attribute attr_16 = new Attribute();
		attr_16.ID=0x006f;
		attr_16.Name="StatusFlags";
		DataType dt_16 = new DataType();
		dt_16.ID=0x18;
		dt_16.des="8-bit bitmap";
		attr_16.dataType=dt_16;
		c0012.AddAttribute(attr_16);
		clousers.add(c0012);
		
		//0x0013
		Cluster c0013 = new Cluster();
		c0013.ID=0x0013;
		c0013.Name="Multistate Output (Basic)";
		Attribute attr_17 = new Attribute();
		attr_17.ID=0x0055;
		attr_17.Name="PresentValue";
		DataType dt_17 = new DataType();
		dt_17.ID=0x21;
		dt_17.des="Unsigned 16-bit integer";
		attr_17.dataType=dt_17;
		c0013.AddAttribute(attr_17);
		Attribute attr_18 = new Attribute();
		attr_18.ID=0x006f;
		attr_18.Name="StatusFlags";
		DataType dt_18 = new DataType();
		dt_18.ID=0x18;
		dt_18.des="8-bit bitmap";
		attr_18.dataType=dt_18;
		c0013.AddAttribute(attr_18);
		clousers.add(c0013);
		
		//0x0014
		Cluster c0014 = new Cluster();
		c0014.ID=0x0014;
		c0014.Name="Multistate Value (Basic)";
		Attribute attr_19 = new Attribute();
		attr_19.ID=0x0055;
		attr_19.Name="PresentValue";
		DataType dt_19 = new DataType();
		dt_19.ID=0x21;
		dt_19.des="Unsigned 16-bit integer";
		attr_19.dataType=dt_19;
		c0014.AddAttribute(attr_19);
		Attribute attr_20 = new Attribute();
		attr_20.ID=0x006f;
		attr_20.Name="StatusFlags";
		DataType dt_20 = new DataType();
		dt_20.ID=0x18;
		dt_20.des="8-bit bitmap";
		attr_20.dataType=dt_20;
		c0014.AddAttribute(attr_20);
		clousers.add(c0014);
		
		//0x0015
		Cluster c0015 = new Cluster();
		c0015.ID=0x0015;
		c0015.Name="Commissioning";
		clousers.add(c0015);
		
		//0x0100
		Cluster c0100 = new Cluster();
		c0100.ID=0x0100;
		c0100.Name="Shade Configuration";
		clousers.add(c0100);
		
		//0x0101
		Cluster c0101 = new Cluster();
		c0101.ID=0x0101;
		c0101.Name="Door Lock";
		clousers.add(c0101);
		
		//0x0102
		Cluster c0102 = new Cluster();
		c0102.ID=0x0102;
		c0102.Name="Window Convering";
		clousers.add(c0102);
		
		//0x0200
		Cluster c0200 = new Cluster();
		c0200.ID=0x0200;
		c0200.Name="Pump Configuration and Control";
		Attribute attr_21 = new Attribute();
		attr_21.ID=0x0010;
		attr_21.Name="PumpStatus";
		DataType dt_21 = new DataType();
		dt_21.ID=0x19;
		dt_21.des="16-bit bitmap";
		attr_21.dataType=dt_21;
		c0200.AddAttribute(attr_21);
		Attribute attr_22 = new Attribute();
		attr_22.ID=0x0013;
		attr_22.Name="Capacity";
		DataType dt_22 = new DataType();
		dt_22.ID=0x29;
		dt_22.des="Signed 16-bit integer";
		attr_22.dataType=dt_22;
		c0200.AddAttribute(attr_22);
		clousers.add(c0200);
		
		//0x0201
		Cluster c0201 = new Cluster();
		c0201.ID=0x0201;
		c0201.Name="Thermostat";
		Attribute attr_23 = new Attribute();
		attr_23.ID=0x0000;
		attr_23.Name="LocalTemperature";
		DataType dt_23 = new DataType();
		dt_23.ID=0x29;
		dt_23.des="Signed 16-bit bitmap";
		attr_23.dataType=dt_23;
		c0201.AddAttribute(attr_23);
		Attribute attr_24 = new Attribute();
		attr_24.ID=0x0007;
		attr_24.Name="PICoolingDemand";
		DataType dt_24 = new DataType();
		dt_24.ID=0x20;
		dt_24.des="Unsigned 8-bit integer";
		attr_24.dataType=dt_24;
		c0201.AddAttribute(attr_24);
		Attribute attr_25 = new Attribute();
		attr_25.ID=0x0008;
		attr_25.Name="PIHeatingDemand";
		DataType dt_25 = new DataType();
		dt_25.ID=0x20;
		dt_25.des="Unsigned 8-bit integer";
		attr_25.dataType=dt_25;
		c0201.AddAttribute(attr_25);
		clousers.add(c0201);
		
		//0x0202
		Cluster c0202 = new Cluster();
		c0202.ID=0x0202;
		c0202.Name="Fan Control";
		clousers.add(c0202);
		
		//0x0203
		Cluster c0203 = new Cluster();
		c0203.ID=0x0203;
		c0203.Name="Dehumidification Control";
		Attribute attr_26 = new Attribute();
		attr_26.ID=0x0001;
		attr_26.Name="DehumidificationCooling";
		DataType dt_26 = new DataType();
		dt_26.ID=0x20;
		dt_26.des="Unsigned 8-bit integer";
		attr_26.dataType=dt_26;
		c0203.AddAttribute(attr_26);
		clousers.add(c0203);
		
		//0x0204
		Cluster c0204 = new Cluster();
		c0204.ID=0x0204;
		c0204.Name="Thermostat User Interface Configuration";
		clousers.add(c0204);
		
		//0x0300
		Cluster c0300 = new Cluster();
		c0300.ID=0x0300;
		c0300.Name="Color control";
		Attribute attr_27 = new Attribute();
		attr_27.ID=0x0000;
		attr_27.Name="CurrentHue";
		DataType dt_27 = new DataType();
		dt_27.ID=0x20;
		dt_27.des="Unsigned 8-bit integer";
		attr_27.dataType=dt_27;
		c0300.AddAttribute(attr_27);
		Attribute attr_28 = new Attribute();
		attr_28.ID=0x0001;
		attr_28.Name="CurrentSaturation";
		DataType dt_28 = new DataType();
		dt_28.ID=0x20;
		dt_28.des="Unsigned 8-bit integer";
		attr_28.dataType=dt_28;
		c0300.AddAttribute(attr_28);
		Attribute attr_29 = new Attribute();
		attr_29.ID=0x0003;
		attr_29.Name="CurrentX";
		DataType dt_29 = new DataType();
		dt_29.ID=0x21;
		dt_29.des="Unsigned 16-bit integer";
		attr_29.dataType=dt_29;
		c0300.AddAttribute(attr_29);
		Attribute attr_30 = new Attribute();
		attr_30.ID=0x0004;
		attr_30.Name="CurrentY";
		DataType dt_30 = new DataType();
		dt_30.ID=0x21;
		dt_30.des="Unsigned 16-bit integer";
		attr_30.dataType=dt_30;
		c0300.AddAttribute(attr_30);
		Attribute attr_31 = new Attribute();
		attr_31.ID=0x0007;
		attr_31.Name="ColorTemperature";
		DataType dt_31 = new DataType();
		dt_31.ID=0x21;
		dt_31.des="Unsigned 16-bit integer";
		attr_31.dataType=dt_31;
		c0300.AddAttribute(attr_31);
		clousers.add(c0300);
		
		//0x0301
		Cluster c0301 = new Cluster();
		c0301.ID=0x0301;
		c0301.Name="Ballast Configuration";
		clousers.add(c0301);
		
		//0x0400
		Cluster c0400 = new Cluster();
		c0400.ID=0x0400;
		c0400.Name="Illuminance measurement";
		Attribute attr_32 = new Attribute();
		attr_32.ID=0x0000;
		attr_32.Name="MeasuredValue";
		DataType dt_32 = new DataType();
		dt_32.ID=0x21;
		dt_32.des="Unsigned 16-bit integer";
		attr_32.dataType=dt_32;
		c0400.AddAttribute(attr_32);
		Attribute attr_33 = new Attribute();
		attr_33.ID=0x0003;
		attr_33.Name="Tolerance";
		DataType dt_33 = new DataType();
		dt_33.ID=0x21;
		dt_33.des="Unsigned 16-bit integer";
		attr_33.dataType=dt_33;
		c0400.AddAttribute(attr_33);
		clousers.add(c0400);
		
		//0x0401
		Cluster c0401 = new Cluster();
		c0401.ID=0x0401;
		c0401.Name="Illuminance level sensing";
		Attribute attr_34 = new Attribute();
		attr_34.ID=0x0000;
		attr_34.Name="LevelStatus";
		DataType dt_34 = new DataType();
		dt_34.ID=0x30;
		dt_34.des="8-bit enumeration";
		attr_34.dataType=dt_34;
		c0401.AddAttribute(attr_34);
		clousers.add(c0401);
		
		//0x0402
		Cluster c0402 = new Cluster();
		c0402.ID=0x0402;
		c0402.Name="Temperature measurement";
		Attribute attr_35 = new Attribute();
		attr_35.ID=0x0000;
		attr_35.Name="MeasuredValue";
		DataType dt_35 = new DataType();
		dt_35.ID=0x29;
		dt_35.des="Signed 16-bit bitmap";
		attr_35.dataType=dt_35;
		c0402.AddAttribute(attr_35);
		Attribute attr_36 = new Attribute();
		attr_36.ID=0x0003;
		attr_36.Name="Tolerance";
		DataType dt_36 = new DataType();
		dt_36.ID=0x21;
		dt_36.des="Unsigned 16-bit integer";
		attr_36.dataType=dt_36;
		c0402.AddAttribute(attr_36);
		clousers.add(c0402);
		
		//0x0403
		Cluster c0403 = new Cluster();
		c0403.ID=0x0403;
		c0403.Name="Pressure measurement";
		Attribute attr_37 = new Attribute();
		attr_37.ID=0x0000;
		attr_37.Name="MeasuredValue";
		DataType dt_37 = new DataType();
		dt_37.ID=0x29;
		dt_37.des="Signed 16-bit bitmap";
		attr_37.dataType=dt_37;
		c0403.AddAttribute(attr_37);
		Attribute attr_38 = new Attribute();
		attr_38.ID=0x0003;
		attr_38.Name="Tolerance";
		DataType dt_38 = new DataType();
		dt_38.ID=0x21;
		dt_38.des="Unsigned 16-bit integer";
		attr_38.dataType=dt_38;
		c0403.AddAttribute(attr_38);
		Attribute attr_39 = new Attribute();
		attr_39.ID=0x0010;
		attr_39.Name="ScaledValue";
		DataType dt_39 = new DataType();
		dt_39.ID=0x29;
		dt_39.des="Signed 16-bit bitmap";
		attr_39.dataType=dt_39;
		c0403.AddAttribute(attr_39);
		Attribute attr_40 = new Attribute();
		attr_40.ID=0x0013;
		attr_40.Name="ScaledTolerance";
		DataType dt_40 = new DataType();
		dt_40.ID=0x21;
		dt_40.des="Unsigned 16-bit integer";
		attr_40.dataType=dt_40;
		c0403.AddAttribute(attr_40);
		clousers.add(c0403);
		
		//0x0404
		Cluster c0404 = new Cluster();
		c0404.ID=0x0404;
		c0404.Name="Flow measurement";
		Attribute attr_41 = new Attribute();
		attr_41.ID=0x0000;
		attr_41.Name="MeasuredValue";
		DataType dt_41 = new DataType();
		dt_41.ID=0x21;
		dt_41.des="Unsigned 16-bit integer";
		attr_41.dataType=dt_41;
		c0404.AddAttribute(attr_41);
		Attribute attr_42 = new Attribute();
		attr_42.ID=0x0003;
		attr_42.Name="Tolerance";
		DataType dt_42 = new DataType();
		dt_42.ID=0x21;
		dt_42.des="Unsigned 16-bit integer";
		attr_42.dataType=dt_42;
		c0404.AddAttribute(attr_42);
		clousers.add(c0404);
		
		//0x0405
		Cluster c0405 = new Cluster();
		c0405.ID=0x0405;
		c0405.Name="Humidity measurement";
		Attribute attr_43 = new Attribute();
		attr_43.ID=0x0000;
		attr_43.Name="MeasuredValue";
		DataType dt_43 = new DataType();
		dt_43.ID=0x21;
		dt_43.des="Unsigned 16-bit integer";
		attr_43.dataType=dt_43;
		c0405.AddAttribute(attr_43);
		Attribute attr_44 = new Attribute();
		attr_44.ID=0x0003;
		attr_44.Name="Tolerance";
		DataType dt_44 = new DataType();
		dt_44.ID=0x21;
		dt_44.des="Unsigned 16-bit integer";
		attr_44.dataType=dt_44;
		c0405.AddAttribute(attr_44);
		clousers.add(c0405);
		
		//0x0406
		Cluster c0406 = new Cluster();
		c0406.ID=0x0406;
		c0406.Name="Occupancy sensing";
		Attribute attr_45 = new Attribute();
		attr_45.ID=0x0000;
		attr_45.Name="Occupancy";
		DataType dt_45 = new DataType();
		dt_45.ID=0x18;
		dt_45.des="8-bit bitmap";
		attr_45.dataType=dt_45;
		c0406.AddAttribute(attr_45);
		clousers.add(c0406);
		
		//0x0500
		Cluster c0500 = new Cluster();
		c0500.ID=0x0500;
		c0500.Name="IAS Zone";
		clousers.add(c0500);
		
		//0x0501
		Cluster c0501 = new Cluster();
		c0501.ID=0x0501;
		c0501.Name="IAS ACE";
		clousers.add(c0501);
		
		//0x0502
		Cluster c0502 = new Cluster();
		c0502.ID=0x0502;
		c0502.Name="IAS WD";
		clousers.add(c0502);
		
		//0x0600
		Cluster c0600 = new Cluster();
		c0600.ID=0x0600;
		c0600.Name="BACnet interface";
		clousers.add(c0600);
		
		//0x0601
		Cluster c0601 = new Cluster();
		c0601.ID=0x0601;
		c0601.Name="BACnet Protocol Tunnel";
		clousers.add(c0601);
		
		//0x0602
		Cluster c0602 = new Cluster();
		c0602.ID=0x0602;
		c0602.Name="Analog Input(BACnet Regular)";
		clousers.add(c0602);
		
		//0x0603
		Cluster c0603 = new Cluster();
		c0603.ID=0x0603;
		c0603.Name="Analog Input(BACnet Extended)";
		clousers.add(c0603);
		
		//0x0604
		Cluster c0604 = new Cluster();
		c0604.ID=0x0604;
		c0604.Name="Analog Output(BACnet Regular)";
		clousers.add(c0604);
		
		//0x0605
		Cluster c0605 = new Cluster();
		c0605.ID=0x0605;
		c0605.Name="Analog Output(BACnet Extended)";
		clousers.add(c0605);
		
		//0x0606
		Cluster c0606 = new Cluster();
		c0606.ID=0x0606;
		c0606.Name="Analog Value(BACnet Regular)";
		clousers.add(c0606);
		
		//0x0607
		Cluster c0607 = new Cluster();
		c0607.ID=0x0607;
		c0607.Name="Analog Value(BACnet Extended)";
		clousers.add(c0607);
		
		//0x0608
		Cluster c0608 = new Cluster();
		c0608.ID=0x0608;
		c0608.Name="Binary Input(BACnet Regular)";
		clousers.add(c0608);
		
		//0x0609
		Cluster c0609 = new Cluster();
		c0609.ID=0x0609;
		c0609.Name="Binary Input(BACnet Extended)";
		clousers.add(c0609);
		
		//0x060A
		Cluster c060A = new Cluster();
		c060A.ID=0x060A;
		c060A.Name="Binary Output(BACnet Regular)";
		clousers.add(c060A);
		
		//0x060B
		Cluster c060B = new Cluster();
		c060B.ID=0x060B;
		c060B.Name="Binary Output(BACnet Extended)";
		clousers.add(c060B);
		
		//0x060C
		Cluster c060C = new Cluster();
		c060C.ID=0x060C;
		c060C.Name="Binary Value(BACnet Regular)";
		clousers.add(c060C);
		
		//0x060D
		Cluster c060D = new Cluster();
		c060D.ID=0x060D;
		c060D.Name="Binary Value(BACnet Extended)";
		clousers.add(c060D);
		
		//0x060E
		Cluster c060E = new Cluster();
		c060E.ID=0x060E;
		c060E.Name="Multistate Input(BACnet Regular)";
		clousers.add(c060E);
		
		//0x060F
		Cluster c060F = new Cluster();
		c060F.ID=0x060F;
		c060F.Name="Multistate Input(BACnet Extended)";
		clousers.add(c060F);
		
		//0x0610
		Cluster c0610 = new Cluster();
		c0610.ID=0x0610;
		c0610.Name="Multistate Output(BACnet Regular)";
		clousers.add(c0610);
		
		//0x0611
		Cluster c0611 = new Cluster();
		c0611.ID=0x0611;
		c0611.Name="Multistate Output(BACnet Extended)";
		clousers.add(c0611);
		
		//0x0612
		Cluster c0612 = new Cluster();
		c0612.ID=0x0612;
		c0612.Name="Multistate Value(BACnet Regular)";
		clousers.add(c0612);
		
		//0x0613
		Cluster c0613 = new Cluster();
		c0613.ID=0x0613;
		c0613.Name="Multistate Value(BACnet Extended)";
		clousers.add(c0613);
		
		//0x0700
		Cluster c0700 = new Cluster();
		c0700.ID=0x0700;
		c0700.Name="Price";
		clousers.add(c0700);
		
		//0x0701
		Cluster c0701 = new Cluster();
		c0701.ID=0x0701;
		c0701.Name="Demand Response and Load Control";
		clousers.add(c0701);
		
		//0x0702
		Cluster c0702 = new Cluster();
		c0702.ID=0x0702;
		c0702.Name="Simple Metering";
		clousers.add(c0702);
		
		//0x0703
		Cluster c0703 = new Cluster();
		c0703.ID=0x0703;
		c0703.Name="Message";
		clousers.add(c0703);
		
		//0x0704
		Cluster c0704 = new Cluster();
		c0704.ID=0x0704;
		c0704.Name="Smart Energy Tunneling (Complex Metering)";
		clousers.add(c0704);
		
		//0x0705
		Cluster c0705 = new Cluster();
		c0705.ID=0x0705;
		c0705.Name="Pre-Payment";
		clousers.add(c0705);
	}

	public static Cluster getClusterById(int id)
	{
		for(Cluster c : clousers)
		{
			if(c.ID==id)
			{
				return c;
			}
		}
		return null;
	}
}
