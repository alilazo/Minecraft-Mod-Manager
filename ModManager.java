package com.ali.manager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Scrollbar;

public class ModManager {

	private JFrame frmMinecraftModManager;

	/**
	 * Launch the application.
	 */
	
	//FIX locally for all on File reader
	static File folder = new File("C:\\Users\\lazoa\\AppData\\Roaming\\.minecraft\\mods");
	static ArrayList<String> ModArray = new ArrayList<String>();
	static String[] modData;
	static int modsLoaded = 0;
	
	public static void main(String[] args) {
		File[] listOfFiles = folder.listFiles();
		int Directories = 0;
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if(listOfFiles[i].isFile()) {
				modsLoaded++;
				System.out.println("File: " + listOfFiles[i].getName());
				ModArray.add(listOfFiles[i].getName());
				
			} else if (listOfFiles[i].isDirectory()) {
				Directories++;
				System.out.println("Directory: " + listOfFiles[i].getName());
			}
		}
		
		String[] mods = ModArray.toArray(new String[ModArray.size()]);
		modData = mods;
		
		System.out.println("\n" + modData[1]);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModManager window = new ModManager();
					window.frmMinecraftModManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public ModManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMinecraftModManager = new JFrame();
		frmMinecraftModManager.setResizable(false);
		frmMinecraftModManager.setTitle("Minecraft Mod Manager");
		frmMinecraftModManager.setBackground(Color.WHITE);
		frmMinecraftModManager.setBounds(100, 100, 583, 500);
		frmMinecraftModManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMinecraftModManager.setLocationRelativeTo(null);
		frmMinecraftModManager.getContentPane().setLayout(null);
		
		JLabel lblMinecraftModManager = new JLabel("Minecraft Mod Manager");
		lblMinecraftModManager.setBounds(0, 0, 567, 75);
		lblMinecraftModManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinecraftModManager.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		frmMinecraftModManager.getContentPane().add(lblMinecraftModManager);
		
		JLabel lblCurrentlyUsing = new JLabel("Currently Using: " + folder.getPath());
		lblCurrentlyUsing.setBounds(10, 60, 567, 42);
		frmMinecraftModManager.getContentPane().add(lblCurrentlyUsing);
		
		JButton btnChangeMinecraftLocation = new JButton("Change Minecraft Mod Location");
		btnChangeMinecraftLocation.setForeground(Color.WHITE);
		btnChangeMinecraftLocation.setBackground(new Color(59, 89, 182));
		btnChangeMinecraftLocation.setBounds(30, 372, 253, 42);
		btnChangeMinecraftLocation.setFocusPainted(false);

		frmMinecraftModManager.getContentPane().add(btnChangeMinecraftLocation);
		
		JLabel lblMadeByAlilazo = new JLabel("Made By: Alilazo " + "\u00a9");
		lblMadeByAlilazo.setBounds(10, 425, 121, 35);
		frmMinecraftModManager.getContentPane().add(lblMadeByAlilazo);
		
		JLabel lblModsLoaded = new JLabel("Mods Loaded: " + modsLoaded);
		lblModsLoaded.setBounds(10, 95, 163, 14);
		frmMinecraftModManager.getContentPane().add(lblModsLoaded);
		
		JLabel lblVersion = new JLabel("V 1.0.0");
		lblVersion.setBounds(513, 11, 44, 14);
		frmMinecraftModManager.getContentPane().add(lblVersion);
		
		JList list = new JList(modData);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(30, 113, 527, 248);	
		frmMinecraftModManager.getContentPane().add(list);
		
		JButton btnAddMod = new JButton("Add Mod");
		btnAddMod.setForeground(Color.WHITE);
		btnAddMod.setFocusPainted(false);
		btnAddMod.setBackground(new Color(59, 89, 182));
		btnAddMod.setBounds(304, 372, 253, 42);
		frmMinecraftModManager.getContentPane().add(btnAddMod);
	}
}
