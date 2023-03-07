import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

/**
 * This is the class that handles the game window
 *
 * @author Jonathan Matscheko
 * @version 1.0
 */
public class Window extends JFrame {

    /**
     * The dimensions of the field-buttons
     */
    private static final Dimension FIELD_BUTTON_DIMENSION = new Dimension(Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
    /**
     * The height of the map
     */
    private static int mapHeight;
    /**
     * The width of the map
     */
    private static int mapWidth;
    /**
     * The gridBagConstraints
     */
    private static GridBagConstraints gbc;
    // components
    // panels
    // /**
    //  * This panel is for the filternames
    //  */
    // private static JPanel filterPanel;
    /**
     * The panel that contains the menu buttons
     */
    private static JPanel mainPanel;
    /**
     * The panel that contains the map buttons
     */
    private static JPanel outputPanel;
    // sub panels
    private static JPanel genderPanel;
    private static JPanel positionPanel;
    private static JPanel speciesPanel;
    private static JPanel resourcePanel;
    private static JPanel rangePanel;
    private static JPanel regionPanel;
    private static JPanel releasePanel;
    // sub components
    private static JTextArea outputNameArea;
    private static JTextArea outputGenderArea;
    private static JTextArea outputLaneArea;
    private static JTextArea outputSpeciesArea;
    private static JTextArea outputResourceArea;
    private static JTextArea outputRangeArea;
    private static JTextArea outputRegionArea;
    private static JTextArea outputReleaseArea;
    private static JTextArea outputRemainingNumberArea;
    // reset
    private static JButton resetButton;
    // gender
    private static JComboBox<String> genderComboBox;
    // lane
    private static LinkedList<JCheckBox> laneJCheckBoxes;
    // species
    private static LinkedList<JCheckBox> speciesJCheckBoxes;
    // resource
    private static JComboBox<String> resourceComboBox;
    // range
    private static JComboBox<String> rangeComboBox;
    // region
    private static LinkedList<JCheckBox> regionJCheckBoxes;
    // release
    private static JComboBox<String> releaseComboBox;
    private static JButton releaseButton;
    // apply
    private static JButton applyButton;
    // debug
    private static JButton debugButton;

    /**
     * This is the main window method, which creates the game-window
     *
     * @param title The title of the window
     */
    public Window(String title) {
        super(title);

        // Set Layout manager
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        gbc = new GridBagConstraints();
        fillWindow();

    }

    private void fillWindow() {
        // setup of the panels
        // setup of the filter panel
        // filterPanel = new JPanel();
        // initializeFilterPanel();
        // setup of the menu panel
        mainPanel = new JPanel();
        initializeMenuPanel();
        // setup of the map panel
        outputPanel = new JPanel();
        initializeOutputPanel();
        // for the faster debugging
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    updateOutput();
                }
                updateOutput();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        // placement of the panels
        // placement of the menu panel
        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // add(filterPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(mainPanel, gbc);
        gbc.insets = new Insets(5, 0, 0, 0);
        // placement of the map panel
        gbc.gridwidth = mapWidth;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(outputPanel, gbc);
        // to make the "WHAT"s more noticable

        // for (Component component: this.getComponents()) {
        //     for (Component component1: component.getParent().getComponents()) {
        //         if (component1.getClass().equals(JCheckBox.class)) {
        //             System.out.println("test");
        //             if (((JCheckBox) component1).getText().equals("WHAT")) {
        //                 component.setForeground(Color.CYAN);
        //             }
        //         }
        //     }
        //     if (component.getName()!=null) {
        //         if (component.getName().equals("WHAT")) {
        //             component.setForeground(Color.CYAN);
        //         }
        //     }
        // }
    }

    /**
     * This method adds the given component at the given location to the given panel
     *
     * @param component          The given component
     * @param horizontalLocation The given horizontal location
     * @param verticalLocation   The given vertical location
     * @param panel              The given panel
     */
    private void placeComponentOnCoordinatesWithGBC(JComponent component, int horizontalLocation, int verticalLocation, JPanel panel) {
        gbc.gridx = horizontalLocation;
        gbc.gridy = verticalLocation;
        panel.add(component, gbc);
        resetGBCValues();
    }

    /**
     * This method resets the values of the gridBagConstraints to zero
     */
    private void resetGBCValues() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
    }

    // These methods help in the creation of the window

    // /**
    //  * This method initializes the filter panel
    //  */
    // private void initializeFilterPanel() {
    //filterPanel.setSize(2, 2);
    //JLabel filterLabel = new JLabel();
    //filterLabel.setText(Constants.REMAINING_CHAMPIONS_TOP_BAR);
    //placeComponentOnCoordinatesWithGBC(filterLabel, 0, 0, filterPanel);
    //JLabel appliedFilterLabel = new JLabel();
    //appliedFilterLabel.setText(Main.returnFilterString());
    //placeComponentOnCoordinatesWithGBC(appliedFilterLabel, 0, 1, filterPanel);
    // }

    /**
     * This method initializes the menu panel
     */
    private void initializeMenuPanel() {
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setSize(8, 20);
        gbc.insets = new Insets(1, 1, 1, 1);
        if (Main.debug) {
            mainPanel.setBackground(new Color(0, 150, 255));
        } else {
            mainPanel.setBackground(Color.BLACK);
        }
        gbc.fill = GridBagConstraints.BOTH;
        // setup of the menu layout
        GridBagLayout menuLayout = new GridBagLayout();
        mainPanel.setLayout(menuLayout);
        // placement of the hint button
        debugButton = new JButton();
        if (Main.debug) {
            debugButton.setText("debug");
        } else {
            debugButton.setText("normal");
        }
        debugButton.addActionListener(e -> pressDebugButton());
        placeComponentOnCoordinatesWithGBC(debugButton, 0, 0, mainPanel);
        resetButton = new JButton();
        initializeResetButton();
        placeComponentOnCoordinatesWithGBC(resetButton, 0, 1, mainPanel);

        JLabel genderHeader = new JLabel();
        genderHeader.setForeground(Color.WHITE);
        genderHeader.setText("gender");
        placeComponentOnCoordinatesWithGBC(genderHeader, 1, 0, mainPanel);
        genderPanel = new JPanel();
        genderComboBox = new JComboBox<>();
        initializeGenderPanel();
        placeComponentOnCoordinatesWithGBC(genderComboBox, 0, 0, genderPanel);
        placeComponentOnCoordinatesWithGBC(genderPanel, 1, 1, mainPanel);

        JLabel laneHeader = new JLabel();
        laneHeader.setForeground(Color.WHITE);
        laneHeader.setText("lane");
        placeComponentOnCoordinatesWithGBC(laneHeader, 2, 0, mainPanel);
        positionPanel = new JPanel();
        initializePositionPanel();
        placeComponentOnCoordinatesWithGBC(positionPanel, 2, 1, mainPanel);

        JLabel speciesHeader = new JLabel();
        speciesHeader.setForeground(Color.WHITE);
        speciesHeader.setText("species");
        placeComponentOnCoordinatesWithGBC(speciesHeader, 3, 0, mainPanel);
        speciesPanel = new JPanel();
        initializeSpeciesPanel();
        placeComponentOnCoordinatesWithGBC(speciesPanel, 3, 1, mainPanel);

        JLabel resourceHeader = new JLabel();
        resourceHeader.setForeground(Color.WHITE);
        resourceHeader.setText("resource");
        placeComponentOnCoordinatesWithGBC(resourceHeader, 4, 0, mainPanel);
        resourcePanel = new JPanel();
        initializeResourcePanel();
        placeComponentOnCoordinatesWithGBC(resourcePanel, 4, 1, mainPanel);

        JLabel rangeHeader = new JLabel();
        rangeHeader.setForeground(Color.WHITE);
        rangeHeader.setText("range");
        placeComponentOnCoordinatesWithGBC(rangeHeader, 5, 0, mainPanel);
        rangePanel = new JPanel();
        initializeRangePanel();
        placeComponentOnCoordinatesWithGBC(rangePanel, 5, 1, mainPanel);

        JLabel regionHeader = new JLabel();
        regionHeader.setForeground(Color.WHITE);
        regionHeader.setText("region");
        placeComponentOnCoordinatesWithGBC(regionHeader, 6, 0, mainPanel);
        regionPanel = new JPanel();
        initializeRegionPanel();
        placeComponentOnCoordinatesWithGBC(regionPanel, 6, 1, mainPanel);

        JLabel releaseHeader = new JLabel();
        releaseHeader.setForeground(Color.WHITE);
        releaseHeader.setText("release");
        placeComponentOnCoordinatesWithGBC(releaseHeader, 7, 0, mainPanel);
        releasePanel = new JPanel();
        initializeReleasePanel();
        placeComponentOnCoordinatesWithGBC(releasePanel, 7, 1, mainPanel);

        applyButton = new JButton();
        initializeApplyButton();
        placeComponentOnCoordinatesWithGBC(applyButton, 8, 1, mainPanel);
    }

    // sub panel initialisation
    private void initializeResetButton() {
        resetButton.setText("Reset filters");
        // gender

        resetButton.addActionListener(e -> {
            pressResetButton();
        });
    }

    private void initializeGenderPanel() {
        genderComboBox.addItem("any");
        if (Main.coolMode) {
            genderComboBox.removeAllItems();
            LinkedList<String> addedGenders = new LinkedList<>();
            for (Champion remainingChampion : Main.remainingChampions) {
                if (!addedGenders.contains(remainingChampion.getGender().name())) {
                    addedGenders.add(remainingChampion.getGender().name());
                }
            }
            for (String addedGender : addedGenders) {
                genderComboBox.addItem(addedGender);
            }
        } else {
            for (Gender currentGender : Gender.values()) {
                if (!currentGender.name().equals(Constants.WHAT_STRING) && !currentGender.name().equals(Constants.NONE_STRING)) {
                    genderComboBox.addItem(currentGender.name());
                }
                if (Main.debug && currentGender.name().equals(Constants.WHAT_STRING)) {
                    genderComboBox.addItem(currentGender.name());
                }
            }
        }
    }

    private void initializePositionPanel() {
        positionPanel.setLayout(new GridBagLayout());
        laneJCheckBoxes = new LinkedList<>();
        int i = 0;
        for (Lane currentLane : Lane.values()) {
            JCheckBox currentLaneCheckBox = new JCheckBox();
            if (!currentLane.name().equals(Constants.WHAT_STRING) && !currentLane.name().equals(Constants.NONE_STRING)) {
                currentLaneCheckBox.setText(currentLane.name());
                laneJCheckBoxes.add(currentLaneCheckBox);
                placeComponentOnCoordinatesWithGBC(currentLaneCheckBox, 1, i, positionPanel);
                i++;
            }
            if (Main.debug && currentLane.name().equals(Constants.WHAT_STRING)) {
                currentLaneCheckBox.setText(currentLane.name());
                laneJCheckBoxes.add(currentLaneCheckBox);
                placeComponentOnCoordinatesWithGBC(currentLaneCheckBox, 1, i, positionPanel);
                i++;
            }
        }
    }

    private void initializeSpeciesPanel() {
        speciesPanel.setLayout(new GridBagLayout());
        speciesJCheckBoxes = new LinkedList<>();
        int speciesAmount = Species.values().length;
        int i = 0;
        int j = 0;
        for (Species currentSpecies : Species.values()) {
            if (!currentSpecies.name().equals(Constants.WHAT_STRING) && !currentSpecies.name().equals(Constants.NONE_STRING)) {
                JCheckBox currentSpeciesCheckBox = new JCheckBox();
                currentSpeciesCheckBox.setText(currentSpecies.name());
                speciesJCheckBoxes.add(currentSpeciesCheckBox);
                placeComponentOnCoordinatesWithGBC(currentSpeciesCheckBox, j, i, speciesPanel);
                i++;
            }
            if (Main.debug && currentSpecies.name().equals(Constants.WHAT_STRING)) {
                JCheckBox currentSpeciesCheckBox = new JCheckBox();
                currentSpeciesCheckBox.setText(currentSpecies.name());
                speciesJCheckBoxes.add(currentSpeciesCheckBox);
                placeComponentOnCoordinatesWithGBC(currentSpeciesCheckBox, j, i, speciesPanel);
                i++;
            }
            if (i == speciesAmount / 2) {
                j = 1;
                i = 0;
            }
        }
    }

    private void initializeResourcePanel() {
        resourceComboBox = new JComboBox<>();
        resourceComboBox.addItem("any");
        for (SecondaryResource currentResource : SecondaryResource.values()) {
            if (!currentResource.name().equals(Constants.WHAT_STRING) && !currentResource.name().equals(Constants.NONE_STRING)) {
                resourceComboBox.addItem(currentResource.name());
            }
            if (Main.debug && currentResource.name().equals(Constants.WHAT_STRING)) {
                resourceComboBox.addItem(currentResource.name());
            }
        }
        placeComponentOnCoordinatesWithGBC(resourceComboBox, 0, 0, resourcePanel);
    }

    private void initializeRangePanel() {
        rangeComboBox = new JComboBox<>();
        rangeComboBox.addItem("any");
        for (Range currentRange : Range.values()) {
            if (!currentRange.name().equals(Constants.WHAT_STRING) && !currentRange.name().equals(Constants.NONE_STRING)) {
                rangeComboBox.addItem(currentRange.name());
            }
            if (Main.debug && currentRange.name().equals(Constants.WHAT_STRING)) {
                rangeComboBox.addItem(currentRange.name());
            }
        }
        placeComponentOnCoordinatesWithGBC(rangeComboBox, 0, 0, rangePanel);
    }

    private void initializeRegionPanel() {
        regionPanel.setLayout(new GridBagLayout());
        regionJCheckBoxes = new LinkedList<>();
        int i = 0;
        for (Region currentRegion : Region.values()) {
            if (!currentRegion.name().equals(Constants.WHAT_STRING) && !currentRegion.name().equals(Constants.NONE_STRING)) {
                JCheckBox currentRegionCheckBox = new JCheckBox();
                currentRegionCheckBox.setText(currentRegion.name());
                regionJCheckBoxes.add(currentRegionCheckBox);
                placeComponentOnCoordinatesWithGBC(currentRegionCheckBox, 1, i, regionPanel);
                i++;
            }
            if (Main.debug && currentRegion.name().equals(Constants.WHAT_STRING)) {
                JCheckBox currentRegionCheckBox = new JCheckBox();
                currentRegionCheckBox.setText(currentRegion.name());
                regionJCheckBoxes.add(currentRegionCheckBox);
                placeComponentOnCoordinatesWithGBC(currentRegionCheckBox, 1, i, regionPanel);
                i++;
            }
        }
    }

    private void initializeReleasePanel() {
        releaseButton = new JButton();
        releaseButton.setText("=");
        releaseButton.addActionListener(e -> pressReleaseButton());
        placeComponentOnCoordinatesWithGBC(releaseButton, 0, 0, releasePanel);
        releaseComboBox = new JComboBox<>();
        releaseComboBox.addItem("0");
        for (int i = 2009; i < 2024; i++) {
            releaseComboBox.addItem(String.valueOf(i));
        }
        placeComponentOnCoordinatesWithGBC(releaseComboBox, 1, 0, releasePanel);
    }

    private void initializeApplyButton() {
        applyButton.setText("Apply filters");
        // gender

        applyButton.addActionListener(e -> {
            pressApplyButton();
        });
    }

    private void initializeOutputPanel() {
        int i = 0;
        outputNameArea = new JTextArea();
        initializeOutputParts(outputNameArea, i, Constants.DISPLAY_ELEMENT_WIDTH_NAME);
        i++;
        outputGenderArea = new JTextArea();
        initializeOutputParts(outputGenderArea, i, Constants.DISPLAY_ELEMENT_WIDTH_GENDER);
        i++;
        outputLaneArea = new JTextArea();
        initializeOutputParts(outputLaneArea, i, Constants.DISPLAY_ELEMENT_WIDTH_POSITION);
        i++;
        outputSpeciesArea = new JTextArea();
        initializeOutputParts(outputSpeciesArea, i, Constants.DISPLAY_ELEMENT_WIDTH_SPECIES);
        i++;
        outputResourceArea = new JTextArea();
        initializeOutputParts(outputResourceArea, i, Constants.DISPLAY_ELEMENT_WIDTH_RESOURCE);
        i++;
        outputRangeArea = new JTextArea();
        initializeOutputParts(outputRangeArea, i, Constants.DISPLAY_ELEMENT_WIDTH_RANGE);
        i++;
        outputRegionArea = new JTextArea();
        initializeOutputParts(outputRegionArea, i, Constants.DISPLAY_ELEMENT_WIDTH_REGION);
        i++;
        outputReleaseArea = new JTextArea();
        initializeOutputParts(outputReleaseArea, i, Constants.DISPLAY_ELEMENT_WIDTH_RELEASE);
        i++;
        outputRemainingNumberArea = new JTextArea();
        initializeOutputParts(outputRemainingNumberArea, i, 0);
        updateOutput();
    }

    private void initializeOutputParts(JTextArea area, int i, int width) {
        area.setEditable(false);
        area.setSize(width, 10);
        area.setDragEnabled(false);
        area.setAutoscrolls(true);
        area.setFocusTraversalKeysEnabled(true);
        placeComponentOnCoordinatesWithGBC(area, i, 2, mainPanel);
    }

    // button presses
    private void pressDebugButton() {
        Main.debug = !Main.debug;
        pressResetButton();
        pressApplyButton();
        // System.out.println(Main.debug);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        Main.initializeWindow();
        //fillWindow();
    }

    private void pressResetButton() {
        genderComboBox.setSelectedItem("any");
        for (JCheckBox laneBox : laneJCheckBoxes) {
            laneBox.setSelected(false);
        }
        for (JCheckBox speciesBox : speciesJCheckBoxes) {
            speciesBox.setSelected(false);
        }
        resourceComboBox.setSelectedItem("any");
        rangeComboBox.setSelectedItem("any");
        for (JCheckBox regionBox : regionJCheckBoxes) {
            regionBox.setSelected(false);
        }
        releaseComboBox.setSelectedItem("0");
        releaseButton.setText("=");
        updateOutput();
    }

    private void pressReleaseButton() {
        switch (releaseButton.getText()) {
            case "<" -> releaseButton.setText("=");
            case "=" -> releaseButton.setText(">");
            case ">" -> releaseButton.setText("<");
        }
    }

    private void pressApplyButton() {
        // gender
        String genderString = String.valueOf(genderComboBox.getSelectedItem());
        if (genderString.equals(Constants.ANY)) {
            Main.filteredGender = null;
        } else {
            Main.filteredGender = Gender.toGender(genderString);
        }
        // lane
        LinkedList<Lane> filteredLanes = new LinkedList<>();
        for (JCheckBox laneBox : laneJCheckBoxes) {
            if (laneBox.isSelected()) {
                filteredLanes.add(Lane.toLane(laneBox.getText()));
            }
        }
        if (filteredLanes.isEmpty()) {
            Main.filteredLanes = new LinkedList<>();
        } else {
            Main.filteredLanes = filteredLanes;
        }
        // species
        LinkedList<Species> filteredSpecies = new LinkedList<>();
        for (JCheckBox speciesBox : speciesJCheckBoxes) {
            if (speciesBox.isSelected()) {
                filteredSpecies.add(Species.toSpecies(speciesBox.getText()));
            }
        }
        if (filteredSpecies.isEmpty()) {
            Main.filteredSpecieses = new LinkedList<>();
        } else {
            Main.filteredSpecieses = filteredSpecies;
        }
        // resource
        String resourceString = String.valueOf(resourceComboBox.getSelectedItem());
        if (resourceString.equals(Constants.ANY)) {
            Main.filteredSecondaryResource = null;
        } else {
            Main.filteredSecondaryResource = SecondaryResource.toSecondaryResource(resourceString);
        }
        // range
        LinkedList<Range> filteredRanges = new LinkedList<>();
        if (rangeComboBox.getSelectedItem().equals(Constants.ANY)) {
            Main.filteredRanges = new LinkedList<>();
        } else {
            if (rangeComboBox.getSelectedItem().equals("MELEE")) {
                filteredRanges.add(Range.toRange("MELEE"));
            }
            if (rangeComboBox.getSelectedItem().equals("RANGED")) {
                filteredRanges.add(Range.toRange("RANGED"));
            }
            if (rangeComboBox.getSelectedItem().equals("BOTH")) {
                filteredRanges.add(Range.toRange("MELEE"));
                filteredRanges.add(Range.toRange("RANGED"));
            }
            if (rangeComboBox.getSelectedItem().equals("WHAT")) {
                filteredRanges.add(Range.toRange("WHAT"));
            }
            Main.filteredRanges = filteredRanges;
        }
        // region
        LinkedList<Region> filteredRegion = new LinkedList<>();
        for (JCheckBox regionBox : regionJCheckBoxes) {
            if (regionBox.isSelected()) {
                filteredRegion.add(Region.toRegion(regionBox.getText()));
            }
        }
        if (filteredRegion.isEmpty()) {
            Main.filteredRegions = new LinkedList<>();
        } else {
            Main.filteredRegions = filteredRegion;
        }
        // release
        Main.filteredYear = Integer.parseInt(String.valueOf(releaseComboBox.getSelectedItem()));
        Main.yearDirection = releaseButton.getText();
        //
        Main.updateRemainingChampions();
        updateOutput();
        if (Main.coolMode) {
            initializeGenderPanel();
        }
    }

    // update output
    private void updateOutput() {
        outputNameArea.setText(Helper.padString("Name:", " ", Constants.DISPLAY_ELEMENT_WIDTH_NAME, true));
        outputGenderArea.setText(Helper.padString("Gender:", " ", Constants.DISPLAY_ELEMENT_WIDTH_GENDER, true));
        outputLaneArea.setText(Helper.padString("Position(s):", " ", Constants.DISPLAY_ELEMENT_WIDTH_POSITION, true));
        outputSpeciesArea.setText(Helper.padString("Species:", " ", Constants.DISPLAY_ELEMENT_WIDTH_SPECIES, true));
        outputResourceArea.setText(Helper.padString("Resource:", " ", Constants.DISPLAY_ELEMENT_WIDTH_RESOURCE, true));
        outputRangeArea.setText(Helper.padString("Range:", " ", Constants.DISPLAY_ELEMENT_WIDTH_RANGE, true));
        outputRegionArea.setText(Helper.padString("Region(s):", " ", Constants.DISPLAY_ELEMENT_WIDTH_REGION, true));
        outputReleaseArea.setText(Helper.padString("Release year:", " ", Constants.DISPLAY_ELEMENT_WIDTH_RELEASE, true));
        outputRemainingNumberArea.setText(Main.remainingChampions.size() + "\n Champion/-s \n remain");
        if (Main.remainingChampions.size() == 0) {
            outputRemainingNumberArea.setForeground(Color.RED);
        } else if (Main.remainingChampions.size() == 1) {
            outputRemainingNumberArea.setForeground(Color.GREEN);
        } else {
            outputRemainingNumberArea.setForeground(Color.BLACK);
        }
        int i = 0;
        for (Champion currentChampion : Main.getRemainingChampions()) {
            if (i == Constants.MAXIMUM_NUMBER_OF_SHOWN_CHAMPS) {
                break;
            }
            outputNameArea.append("\n" + currentChampion.getName());
            outputGenderArea.append("\n" + currentChampion.getGender());
            outputLaneArea.append("\n" + currentChampion.returnLaneString());
            outputSpeciesArea.append("\n" + currentChampion.returnSpeciesString());
            outputResourceArea.append("\n" + currentChampion.returnResourceString());
            outputRangeArea.append("\n" + currentChampion.returnRangeString());
            outputRegionArea.append("\n" + currentChampion.returnRegionString());
            outputReleaseArea.append("\n" + currentChampion.returnReleaseString());
            i++;
        }
    }


}