package videoStoreSystem;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VideoStore_AboutPanel extends JPanel
{

	/**
	 * Create the panel.
	 */
	public VideoStore_AboutPanel()
	{
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Video Store System");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblAuthor = new JLabel("Philip Dumaresq");
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 0);
		gbc_lblAuthor.gridx = 0;
		gbc_lblAuthor.gridy = 1;
		add(lblAuthor, gbc_lblAuthor);
		
		JLabel lblCopyright = new JLabel("2016");
		GridBagConstraints gbc_lblCopyright = new GridBagConstraints();
		gbc_lblCopyright.insets = new Insets(0, 0, 5, 0);
		gbc_lblCopyright.gridx = 0;
		gbc_lblCopyright.gridy = 2;
		add(lblCopyright, gbc_lblCopyright);
		
		JLabel lblCompany = new JLabel("Heritage college");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 3;
		add(lblCompany, gbc_lblCompany);

	}

}
