package Quiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
public class Configuration implements ActionListener{
    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answerA = new JLabel();
    JLabel answerB = new JLabel();
    JLabel answerC = new JLabel();
    JLabel answerD = new JLabel();
    JLabel timer_label = new JLabel();
    JLabel seconds_label = new JLabel();
    JTextField correct_answers_label = new JTextField();
    JTextField percentage = new JTextField();
    Questions questions = new Questions();
    int correct_answers = 0;
    int seconds = 10;
    char answer;
    int index;
    public Configuration() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(685,750);
        frame.setTitle("History of Ukraine Trivia Quiz");
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        textField.setBounds(0,0,685,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(Color.decode("#E1E5EB"));
        textField.setFont(new Font("Century Gothic",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0,50,685,125);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(Color.decode("#E1E5EB"));
        textArea.setFont(new Font("Comic Sans MS",Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0,175,100,100);
        buttonA.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,275,100,100);
        buttonB.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,375,100,100);
        buttonC.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,475,100,100);
        buttonD.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answerA.setBounds(125,175,500,100);
        answerA.setBackground(new Color(50,50,50));
        answerA.setForeground(Color.decode("#D5CAE4"));
        answerA.setFont(new Font("Comic Sans MS",Font.PLAIN,35));

        answerB.setBounds(125,275,500,100);
        answerB.setBackground(new Color(50,50,50));
        answerB.setForeground(Color.decode("#D5CAE4"));
        answerB.setFont(new Font("Comic Sans MS",Font.PLAIN,35));

        answerC.setBounds(125,375,500,100);
        answerC.setBackground(new Color(50,50,50));
        answerC.setForeground(Color.decode("#D5CAE4"));
        answerC.setFont(new Font("Comic Sans MS",Font.PLAIN,35));

        answerD.setBounds(125,475,500,100);
        answerD.setBackground(new Color(50,50,50));
        answerD.setForeground(Color.decode("#D5CAE4"));
        answerD.setFont(new Font("Comic Sans MS",Font.PLAIN,35));

        timer_label.setBounds(565,590,100,25);
        timer_label.setBackground(new Color(50,50,50));
        timer_label.setForeground(Color.decode("#E59462"));
        timer_label.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        timer_label.setHorizontalAlignment(JTextField.CENTER);
        timer_label.setText("Timer");

        seconds_label.setBounds(570,615,100,100);
        seconds_label.setBackground(new Color(25,25,25));
        seconds_label.setForeground(Color.decode("#E59462"));
        seconds_label.setFont(new Font("Comic Sans MS",Font.BOLD,60));
        seconds_label.setBorder(BorderFactory.createBevelBorder(1));
        seconds_label.setOpaque(true);
        seconds_label.setHorizontalAlignment(JTextField.CENTER);
        seconds_label.setText(String.valueOf(seconds));

        correct_answers_label.setBounds(225,225,200,100);
        correct_answers_label.setBackground(new Color(25,25,25));
        correct_answers_label.setForeground(Color.decode("#81CAD6"));
        correct_answers_label.setFont(new Font("Comic Sans MS",Font.BOLD,50));
        correct_answers_label.setBorder(BorderFactory.createBevelBorder(1));
        correct_answers_label.setHorizontalAlignment(JTextField.CENTER);
        correct_answers_label.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(Color.decode("#EDCD44"));
        percentage.setFont(new Font("Comic Sans MS",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(timer_label);
        frame.add(seconds_label);
        frame.add(answerA);
        frame.add(answerB);
        frame.add(answerC);
        frame.add(answerD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }
    public void nextQuestion() {

        if(index>=questions.getQuestions().length) showResults();

        else {
            textField.setText("Question "+(index+1));
            textArea.setText(questions.getQuestions()[index]);
            answerA.setText(questions.getOptions()[index][0]);
            answerB.setText(questions.getOptions()[index][1]);
            answerC.setText(questions.getOptions()[index][2]);
            answerD.setText(questions.getOptions()[index][3]);
            timer.start();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        buttonsEnable(false);

        if(e.getSource()==buttonA) {
            answer= 'A';
            if(answer == questions.getAnswers()[index]) correct_answers++;
        }

        if(e.getSource()==buttonB) {
            answer= 'B';
            if(answer == questions.getAnswers()[index]) correct_answers++;
        }

        if(e.getSource()==buttonC) {
            answer= 'C';
            if(answer == questions.getAnswers()[index]) correct_answers++;
        }

        if(e.getSource()==buttonD) {
            answer= 'D';
            if(answer == questions.getAnswers()[index]) correct_answers++;
        }

        showAnswer();
    }
    public void showAnswer() {

        timer.stop();
        buttonsEnable(false);

        if(questions.getAnswers()[index] != 'A') answerA.setForeground(Color.decode("#ed533b"));
        if(questions.getAnswers()[index] != 'B') answerB.setForeground(Color.decode("#ed533b"));
        if(questions.getAnswers()[index] != 'C') answerC.setForeground(Color.decode("#ed533b"));
        if(questions.getAnswers()[index] != 'D') answerD.setForeground(Color.decode("#ed533b"));

        if(questions.getAnswers()[index] == 'A') answerA.setForeground(Color.decode("#7fed3b"));
        if(questions.getAnswers()[index] == 'B') answerB.setForeground(Color.decode("#7fed3b"));
        if(questions.getAnswers()[index] == 'C') answerC.setForeground(Color.decode("#7fed3b"));
        if(questions.getAnswers()[index] == 'D') answerD.setForeground(Color.decode("#7fed3b"));

        pause.setRepeats(false);
        pause.start();
    }
    public void showResults(){

        buttonsEnable(false);
        int result = (int)((correct_answers/(double)questions.getQuestions().length)*100);

        textField.setText("RESULTS!");
        textArea.setText("");
        answerA.setText("");
        answerB.setText("");
        answerC.setText("");
        answerD.setText("");

        correct_answers_label.setText("("+ correct_answers +"/"+questions.getQuestions().length+")");
        percentage.setText(result+"%");

        frame.add(correct_answers_label);
        frame.add(percentage);

    }
    public void buttonsEnable(boolean bool){
        buttonA.setEnabled(bool);
        buttonB.setEnabled(bool);
        buttonC.setEnabled(bool);
        buttonD.setEnabled(bool);
    }
    Timer timer = new Timer(1000, e -> {
        seconds--;
        seconds_label.setText(String.valueOf(seconds));
        if(seconds<=0) showAnswer();
    });
    Timer pause = new Timer(1500, e -> {

        answerA.setForeground(Color.decode("#D5CAE4"));
        answerB.setForeground(Color.decode("#D5CAE4"));
        answerC.setForeground(Color.decode("#D5CAE4"));
        answerD.setForeground(Color.decode("#D5CAE4"));

        answer = ' ';
        seconds = 10;
        seconds_label.setText(String.valueOf(seconds));
        buttonsEnable(true);
        index++;
        nextQuestion();
    });
}
