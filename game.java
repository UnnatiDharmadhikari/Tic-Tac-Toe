import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class game extends JFrame implements ActionListener
{
int i,j,x,y;
static int movecount=0,n=3;
static int[][] arr=new int[10][10]; 				
static Icon ic1,ic2;
static JButton b[]=new JButton[100];
JButton back1,c1,c2,c3,c4,c5,c,f,s,t,a,undo,reset,restart;
JLabel l1,mvcnt,header,sel,player1,player2;
MoveInfo lastMove = null;
public static final String CAPTION_UNDO = "Undo";
public static final String CAPTION_REDO = "Redo";

public static final String ICON_PREFIX_CROSS = "C";
public static final String ICON_PREFIX_FRUIT = "F";
public static final String ICON_PREFIX_AB = "A";
public static final String ICON_PREFIX_TOM = "T";
public static final String ICON_PREFIX_SMILEY = "S";


public static String p1 = "Player 1";
public static String p2 = "Player 2";

static JButton start,quit,help;
public void showMenu(){
repaint();
setContentPane(new JLabel(new ImageIcon("images/Grid.png")));
revalidate();
c1=new JButton();
c1.setMnemonic(KeyEvent.VK_3);
c1.setFocusPainted(false);
c1.setContentAreaFilled(false);
c1.setBorderPainted(false);
c1.setOpaque(false);

c2=new JButton();
c2.setMnemonic(KeyEvent.VK_4);
c2.setFocusPainted(false);
c2.setContentAreaFilled(false);
c2.setBorderPainted(false);
c2.setOpaque(false);

c3=new JButton();
c3.setMnemonic(KeyEvent.VK_5);
c3.setFocusPainted(false);
c3.setContentAreaFilled(false);
c3.setBorderPainted(false);
c3.setOpaque(false);

c4=new JButton();
c4.setMnemonic(KeyEvent.VK_6);
c4.setFocusPainted(false);
c4.setContentAreaFilled(false);
c4.setBorderPainted(false);
c4.setOpaque(false);

c5=new JButton();
c5.setMnemonic(KeyEvent.VK_7);
c5.setFocusPainted(false);
c5.setContentAreaFilled(false);
c5.setBorderPainted(false);
c5.setOpaque(false);

back1=new JButton("  ");
back1.setFocusPainted(false);
back1.setContentAreaFilled(false);
back1.setBorderPainted(false);
back1.setOpaque(false);

c1.setFocusable(false);
c2.setFocusable(false);
c3.setFocusable(false);
c4.setFocusable(false);
c5.setFocusable(false);
back1.setFocusable(false);

c1.setBounds(685,160,170,45);
c2.setBounds(669,256,170,45);
c3.setBounds(636,352,170,45);
c4.setBounds(585,440,170,45);
c5.setBounds(508,523,170,45);
back1.setBounds(340,580,170,45);

add(c1); 
add(c2);
add(c3);
add(c4);
add(c5);
add(back1);

c1.addActionListener(this);
c2.addActionListener(this);
c3.addActionListener(this);
c4.addActionListener(this);
c5.addActionListener(this);
back1.addActionListener(this);
}

public void showimageMenu(){
repaint();
setContentPane(new JLabel(new ImageIcon("images/Themes.png")));
revalidate();

c=new JButton(" ");
c.setFocusPainted(false);
c.setContentAreaFilled(false);
c.setBorderPainted(false);
c.setOpaque(false);

f=new JButton(" ");
f.setFocusPainted(false);
f.setContentAreaFilled(false);
f.setBorderPainted(false);
f.setOpaque(false);

s=new JButton(" ");
s.setFocusPainted(false);
s.setContentAreaFilled(false);
s.setBorderPainted(false);
s.setOpaque(false);

t=new JButton(" ");
t.setFocusPainted(false);
t.setContentAreaFilled(false);
t.setBorderPainted(false);
t.setOpaque(false);

a=new JButton(" ");
a.setFocusPainted(false);
a.setContentAreaFilled(false);
a.setBorderPainted(false);
a.setOpaque(false);

c.setFocusable(false);
s.setFocusable(false);
f.setFocusable(false);
t.setFocusable(false);
a.setFocusable(false);

c.setBounds(672,190,170,45);
t.setBounds(650,306,170,45);
a.setBounds(600,417,170,45);
s.setBounds(502,505,170,45);
f.setBounds(345,568,170,45);

add(c); 
add(f);
add(s);
add(t);
add(a);

c.addActionListener(this);
f.addActionListener(this);
s.addActionListener(this);
t.addActionListener(this);
a.addActionListener(this);
setVisible(true);
}
public void showButton(){
	repaint();
	setContentPane(new JLabel(new ImageIcon("images/GamePlay.png")));
	revalidate();
	x=225; 
	y=60;
	j=0;
	for(i=0;i<=(n*n)-1;i++,x+=500/n,j++)
	{
		b[i]=new JButton();
		if(j==n)
			{
				j=0; 
				y+=(500/n); 
				x=225;
			}
	b[i].setBounds(x,y,500/n,500/n);
	b[i].setOpaque(false);
	b[i].setContentAreaFilled(false);
	b[i].setBorderPainted(true);
	b[i].setBackground(new java.awt.Color(232,232,232));
	b[i].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	add(b[i]);
	b[i].addActionListener(this);
}//eof for



if(p1==null){
	p1="Player 1";
}

player1 = new JLabel("Player 1 : " + p1);
player1.setBounds(150,15,500,35);
player1.setFont(new java.awt.Font("Comic Sans MS", 0,31));
add(player1);
if(p2==null){
	p2="Player 2";
}

player2 = new JLabel("Player 2 : " + p2);
player2.setBounds(500,15,500,35);
player2.setFont(new java.awt.Font("Comic Sans MS", 0,31));
add(player2);

player1.setForeground(Color.RED);

restart=new JButton();
restart.setContentAreaFilled(false);
restart.setBorderPainted(false);
restart.setFocusPainted(false);
restart.setBounds(88,598,205,45);
add(restart);
restart.addActionListener(this);

undo=new JButton(CAPTION_UNDO);
undo.setFont(new java.awt.Font("Comic Sans MS", 0,22));
undo.setForeground(Color.white);
undo.setFocusPainted(false);
undo.setContentAreaFilled(false);
undo.setBorderPainted(false);
undo.setBounds(348,598,145,45);
add(undo);
undo.setEnabled(false);
undo.addActionListener(this);

reset=new JButton();
reset.setFocusPainted(false);
reset.setContentAreaFilled(false);
reset.setBorderPainted(false);
reset.setBounds(554,598,145,45);
add(reset);
reset.addActionListener(this);

quit=new JButton();
quit.setFocusPainted(false);
quit.setContentAreaFilled(false);
quit.setBorderPainted(false);
quit.setBounds(758,595,145,45);
add(quit);
quit.addActionListener(this);
}


public game(){

super("Tic Tac Toe");

for(int x=0;x<10;x++)
	for(int y=0;y<10;y++)
		arr[x][y]=-1;
setContentPane(new JLabel(new ImageIcon("images/Big-Tic-Tac-Toe-Main-Logo1.jpg")));
header=new JLabel(new ImageIcon("images/Capture12.JPG"));
header.setBounds(210,0,500,120);
add(header);

sel=new JLabel(new ImageIcon("images/Capture22.JPG"));
sel.setBounds(250,100,400,100);
add(sel);
showMenu();
setLayout(null);
setResizable(false);
setBounds(350,30,950,700);
setVisible(true);
p1=JOptionPane.showInputDialog("Enter 1st Player X:");
p2=JOptionPane.showInputDialog("Enter 2nd Player O:");

setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}//eof constructor

public void actionPerformed(ActionEvent e){	
		String themePrefix = ICON_PREFIX_CROSS;
		boolean isGridButton = false;
		boolean isThemeButton = false;
		if(e.getSource()==c1) {
			n=3;
			isGridButton = true;
		} else if(e.getSource()==c2) {
			n=4;
			isGridButton = true;
		} else if(e.getSource()==c3) {
			n=5;
			isGridButton = true;
		} else if(e.getSource()==c4) {
			n=6;
			isGridButton = true;
		} else if(e.getSource()==c5) {
			n=7;
			isGridButton = true;
 		} else if(e.getSource()==c) {
			themePrefix = ICON_PREFIX_CROSS;
		isThemeButton = true;
		} else if(e.getSource()==f) {
			themePrefix = ICON_PREFIX_FRUIT;
		isThemeButton = true;
		} else if(e.getSource()==a) {
			themePrefix = ICON_PREFIX_AB;
		isThemeButton = true;
		}else if(e.getSource()==t) {
			themePrefix = ICON_PREFIX_TOM;
		isThemeButton = true;
		}else if(e.getSource()==s) {
			themePrefix = ICON_PREFIX_SMILEY;
		isThemeButton = true;
		}
		if(isGridButton) {
			remove(c1);
			remove(c2);
			remove(c3);
			remove(c4);
			remove(c5);
			repaint();
			setContentPane(new JLabel(new ImageIcon("images/Grid.png")));
			revalidate();
			showimageMenu();
		}

		if(isThemeButton) {
			ic1=new ImageIcon("images/" + themePrefix + n + "a.png");
			ic2=new ImageIcon("images/" + themePrefix + n + "b.png");
			showButton();
			remove(c);
			remove(f);
			remove(s);
			remove(t);
			remove(a);
		}

	
		int states;
			if(e.getSource()==quit)
			{
			states=JOptionPane.showConfirmDialog(this,"Do you want to really Quit the game?","Quit Confrimation",JOptionPane.YES_NO_OPTION);
			if(states==0)
				System.exit(0);
			}
			if(e.getSource()==restart)
				{
states=JOptionPane.showConfirmDialog(this,"Do you really want to Change The Grid?","Confrimation",JOptionPane.YES_NO_OPTION);
			if(states==0)
				doRestart();
				}
			
			if(e.getSource()==reset)
				{
states=JOptionPane.showConfirmDialog(this,"Do you really want to Reset the game?","Quit Confrimation",JOptionPane.YES_NO_OPTION);
			if(states==0)
				doReset();
				}
			
			if(e.getSource()==undo)
				{
					doUndo();
				}
			if(e.getSource()==back1)
				{
				new Main();
				}
			
			
			int i;
			for(i=0;i<n*n;i++)
			{
				if(e.getSource()==b[i])
				{
					int r,c;
					r=i/n;
					c=i%n;
					if(arr[r][c]==-1)
					{
						movecount++;
						
						if(movecount%2==0)
							{
								setTilePlayed(i, ic2, r, c, 3);
								//next player is player 1 X
								player1.setForeground(Color.RED);
								player2.setForeground(Color.BLACK);
							}
						else
							{
								setTilePlayed(i, ic1, r, c, 1);
								//next player is player 2 O
								player2.setForeground(Color.BLUE);
								player1.setForeground(Color.BLACK);
							}
						setTextUndo();
					}
				}
			
			}
			
			int pl;
			pl=checkwin();
		
			if(pl==1)
				{

					for(int x=0;x<10;x++)
						for(int y=0;y<10;y++)
							arr[x][y]=-1;

					for(int x=0;x<n*n;x++)
						b[x].setEnabled(false);
				JOptionPane.showMessageDialog(game.this,"Player 1 "+ p1 +" Won!!!!");
				doReset();
				}
			if(pl==3)
				{
					
					for(int x=0;x<10;x++)
						for(int y=0;y<10;y++)
							arr[x][y]=-1;

					for(int x=0;x<n*n;x++)
						b[x].setEnabled(false);
				JOptionPane.showMessageDialog(game.this,"Player 2 "+ p2 +" Won!!!!");
				doReset();		
				}
			if(isfull()==1)
			{

					for(int x=0;x<n*n;x++)
						b[x].setEnabled(false);
				JOptionPane.showMessageDialog(game.this,"Tie !!!!");
				doReset();
			}
	}


void setTilePlayed(int tileIndex, Icon tileIcon, int row, int col, int val) {

	lastMove = new MoveInfo(tileIndex, b[tileIndex].getIcon(), row, col, arr[row][col]);
	b[tileIndex].setIcon(tileIcon);
	b[tileIndex].setFocusable(false);
	arr[row][col]=val;
	
}
void setTilePlayed(MoveInfo moveInfo) {
	setTilePlayed(moveInfo.tileIndex, moveInfo.tileIcon, moveInfo.row, moveInfo.col, moveInfo.val);
}
void setTextUndo() {
	undo.setEnabled(true);
	undo.setText(CAPTION_UNDO);

}		
void toggleUndoRedo() {
	if(undo.getText().equals(CAPTION_UNDO)) {
		undo.setText(CAPTION_REDO);
		
	} else {
		undo.setText(CAPTION_UNDO);
		
	}
}
void doRestart() {
	movecount=0;
	for(int x=0;x<10;x++)
		for(int y=0;y<10;y++)
			arr[x][y]=-1;

	movecount=0;
	dispose();
	new game();
	repaint(0,0,600,650);
}
void doReset() {
	movecount=0;
	for(int x=0;x<10;x++)
		for(int y=0;y<10;y++)
			arr[x][y]=-1;

	for(int x=0;x<n*n;x++)
	{
		b[x].setEnabled(true);
		b[x].setIcon(null);
	}
	if(l1!=null)
	l1.setBounds(0,0,0,0);

	lastMove = null;
	player1.setForeground(Color.RED);
	player2.setForeground(Color.BLACK);
}
public void doUndo() {
	if(lastMove != null) {
		setTilePlayed(lastMove);
		--movecount;
		toggleUndoRedo();
	}
}		
int	checkwin(){
	int i,j;

	for(i=0;i<n;i++)	//check rows
	{
		for(j=0;j<n-1;j++)
				if(arr[i][j]!=arr[i][j+1] || arr[i][j]==-1)
					break;	
		
		if(j==n-1)
		{
			if(arr[i][j-1]==1)
				return 1;
			else
			if(arr[i][j-1]==3)
				return 3;
		}
	}
	
	for(i=0;i<n;i++)	//check coloumns
	{
		for(j=0;j<n-1;j++)
				if(arr[j][i]!=arr[j+1][i] || arr[j][i]==-1)
					break;	
		
		if(j==n-1)
		{
			if(arr[j-1][i]==1)
				return 1;
			else
			if(arr[j-1][i]==3)
				return 3;
		}
	} 
	
	
	for(i=0;i<n-1;i++)		//check digonals
		if(arr[i][i]!=arr[i+1][i+1] || arr[i][i]==-1)
			break;	

	if(i==n-1)		
		{
			if(arr[i-1][i-1]==1)
				return 1;
			else
			if(arr[i-1][i-1]==3)
				return 3;
		}
	for(i=0,j=n-1 ; i<n-1 && j>0 ; i++, j--)		//check digonals
		if(arr[i][j]!=arr[i+1][j-1] || arr[i][j]==-1)
			break;	

	if(i==n-1)		
		{
			if(arr[i-1][i-1]==1)
				return 1;
		
			if(arr[i-1][i-1]==3)
				return 3;
		}

	return -1;
}
int isfull(){
	for(int x=0;x<n;x++)
		for(int y=0;y<n;y++)
			if(arr[x][y]==-1)
				return 0;
	return 1;
	
}
class MoveInfo { //Inner class 

	int tileIndex;
	Icon tileIcon;
	int row;
	int col;
	int val;
	public MoveInfo() {
	}
	public MoveInfo(int tileIndex, Icon tileIcon, int row, int col, int val) {
		this.tileIndex = tileIndex;
		this.tileIcon = tileIcon;
		this.row = row;
		this.col = col;
		this.val = val;
	}
	public String ring() {
		return "MoveInfo="+tileIndex+","+tileIcon+","+row+","+col+","+val;
	}
}
}//end of class
