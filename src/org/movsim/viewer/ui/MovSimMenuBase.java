/*
 * Copyright (C) 2010, 2011, 2012 by Arne Kesting, Martin Treiber, Ralph Germ, Martin Budden
 *                                   <movsim.org@gmail.com>
 * -----------------------------------------------------------------------------------------
 * 
 * This file is part of
 * 
 * MovSim - the multi-model open-source vehicular-traffic simulator.
 * 
 * MovSim is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MovSim is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MovSim. If not, see <http://www.gnu.org/licenses/>
 * or <http://www.movsim.org>.
 * 
 * -----------------------------------------------------------------------------------------
 */

package org.movsim.viewer.ui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;

import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.movsim.output.route.FileTrajectories;
import org.movsim.simulator.Simulator;
import org.movsim.viewer.graphics.TrafficCanvas;
import org.movsim.viewer.ui.charts.SpaceTimeSpeedView;
import org.movsim.viewer.util.SwingHelper;

@SuppressWarnings("serial")
public class MovSimMenuBase extends JPanel {
    private static final long serialVersionUID = -2588408479627239336L;
    protected final CanvasPanel canvasPanel;
    final TrafficCanvas trafficCanvas;
    final ResourceBundle resourceBundle;
    private LogWindow logWindow;
    protected Simulator simulator;
    
	private ArrayList<SpaceTimeSpeedView> spatioTemporalDiagrams = new ArrayList<SpaceTimeSpeedView>();
	//private ArrayList<TravelTimesView> travelTimesDiagrams = new ArrayList<TravelTimesView>();
	

    public MovSimMenuBase(CanvasPanel canvasPanel, TrafficCanvas trafficCanvas, ResourceBundle resourceBundle, Simulator simulator) {
    	this.canvasPanel = canvasPanel;
        this.trafficCanvas = trafficCanvas;
        this.resourceBundle = resourceBundle;
        this.simulator = simulator;
    }

    final String resourceString(String string) {
        return resourceBundle.getString(string);
    }

    JMenu helpMenu() {
        final JMenu helpMenu = new JMenu(resourceBundle.getString("HelpMenu")); //$NON-NLS-1$

        helpMenu.add(new JMenuItem(new AbstractAction(resourceBundle.getString("HelpMenuAbout")) {//$NON-NLS-1$
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        handleAbout(actionEvent);
                    }
                }));

        helpMenu.add(new JMenuItem(new AbstractAction(resourceBundle.getString("HelpMenuDocumentation")) {//$NON-NLS-1$
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        handleAbout(actionEvent);
                    }
                })).setEnabled(false);

        final JMenu languageMenu = new JMenu(resourceBundle.getString("LanguageChooser"));
        languageMenu.add(new JMenuItem(new AbstractAction(resourceBundle.getString("English")) {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        }));

        languageMenu.add(new JMenuItem(new AbstractAction(resourceBundle.getString("German")) {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        })).setEnabled(false);

        helpMenu.add(languageMenu);

        return helpMenu;
    }

    void handleAbout(EventObject event) {
        final String titleString = (String) resourceBundle.getObject("AboutTitle"); //$NON-NLS-1$
        final String aboutString = (String) resourceBundle.getObject("AboutText"); //$NON-NLS-1$
        JOptionPane.showMessageDialog(canvasPanel, aboutString, titleString, JOptionPane.INFORMATION_MESSAGE);
    }

    void handleTravelTimeDiagram(ActionEvent actionEvent) {
        // final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
        // if (trafficUi.getStatusPanel().isWithTravelTimes()) {
        // if (cb.isSelected()) {
        // travelTimeDiagram = new TravelTimeDiagram(resourceBundle, cb);
        // } else {
        // SwingHelper.closeWindow(travelTimeDiagram);
        // }
        // } else {
        // JOptionPane.showMessageDialog(frame, resourceBundle.getString("NoTravelTime"));
        // cb.setSelected(false);
        // }
    	 final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
    	 if (cb.isSelected()){
    		 /*this.travelTimesDiagrams.clear();
    		 for(FileTrajectories fileTraj : simulator.getSimulationOutput().getTrajectories()){
    			 this.travelTimesDiagrams.add(new TravelTimesView(fileTraj.getTravelTimesDataSet(), cb, fileTraj));
    		 }*/
    	 } else {
    		/* for(TravelTimesView diagram : this.travelTimesDiagrams){
    			 SwingHelper.closeWindow(diagram);
    		 }
    		 for(FileTrajectories fileTraj : simulator.getSimulationOutput().getTrajectories()){
    			fileTraj.removeTravelTimesDataSet();
    		 }*/
         }
    	
    }

    void handleSpatioTemporalDiagram(ActionEvent actionEvent) {
    	 final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
    	 if (cb.isSelected()){
    		 this.spatioTemporalDiagrams.clear();
    		 for(FileTrajectories fileTraj : simulator.getSimulationOutput().getTrajectories()){
    			 int[] lanes = fileTraj.getLanes();
    			 this.spatioTemporalDiagrams.add(new SpaceTimeSpeedView(/*fileTraj.getSpaceTimeSpeedDataSet(Lanes.MOST_INNER_LANE)*/ null, cb, fileTraj, lanes));
    		 }
    	 } else {
    		 for(SpaceTimeSpeedView diagram : this.spatioTemporalDiagrams){
    			 SwingHelper.closeWindow(diagram);
    		 }
    		 for(FileTrajectories fileTraj : simulator.getSimulationOutput().getTrajectories()){
    			fileTraj.removeSpaceTimeSpeedDataSet();
    		 }
         }
    	
         //final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
         //if (cb.isSelected() && simulator.getSpaceTimeSpeedDataSet()!=null) {
         //	 this.spatioTemporalDiagram = new SpatioTemporalView(simulator.getSpaceTimeSpeedDataSet(),cb);//(simulator, simulator.getRoadNetwork(), cb);
         //} else {
         //SwingHelper.closeWindow(spatioTemporalDiagram);
         //}
    }

    void handleFloatingCarsDiagram(ActionEvent actionEvent) {
        // final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
        // if (cb.isSelected()) {
        // fcAcc = new FloatingCarsAccelerationView();
        // fcSpeed = new FloatingCarsSpeedView();
        // fcTrajectories = new FloatingCarsTrajectoriesView();
        // } else {
        // SwingHelper.closeWindow(fcAcc);
        // SwingHelper.closeWindow(fcSpeed);
        // SwingHelper.closeWindow(fcTrajectories);
        // }
    }

    void handleDetectorsDiagram(ActionEvent actionEvent) {
        // final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
        // if (cb.isSelected()) {
        // detectorsDiagram = new DetectorsView(resourceBundle, cb);
        // } else {
        // SwingHelper.closeWindow(detectorsDiagram);
        // }
    }

    void handleFuelConsumptionDiagram(ActionEvent actionEvent) {
        SwingHelper.notImplemented(canvasPanel);
    }

    protected void handleLogOutput(ActionEvent actionEvent) {
        final JCheckBoxMenuItem cbMenu = (JCheckBoxMenuItem) actionEvent.getSource();
        if (cbMenu.isSelected()) {
            logWindow = new LogWindow(resourceBundle, cbMenu);
        } else {
            SwingHelper.closeWindow(logWindow);
        }
    }

    protected void handleDrawRoadIds(ActionEvent actionEvent) {
        final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
        trafficCanvas.setDrawRoadId(cb.isSelected());
        trafficCanvas.forceRepaintBackground();
    }

    protected void handleDrawSources(ActionEvent actionEvent) {
        final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
        trafficCanvas.setDrawSources(cb.isSelected());
        trafficCanvas.forceRepaintBackground();
    }

    protected void handleDrawSinks(ActionEvent actionEvent) {
        final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
        trafficCanvas.setDrawSinks(cb.isSelected());
        trafficCanvas.forceRepaintBackground();
    }

    protected void handleDrawSpeedLimits(ActionEvent actionEvent) {
        final JCheckBoxMenuItem cb = (JCheckBoxMenuItem) actionEvent.getSource();
        trafficCanvas.setDrawSpeedLimits(cb.isSelected());
        trafficCanvas.forceRepaintBackground();
    }
}
