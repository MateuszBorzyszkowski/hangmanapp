document.getElementById("gameReset").innerHTML = '<span class="okGame" onclick="location.reload()">OK</span>';

function sentencePolish() {
    var sentencePL = new Array(10);
    sentencePL[0] = "Idzie luty podkuj buty";
    sentencePL[1] = "Jak kamień w wodę";
    sentencePL[2] = "Komu w drogę temu czas";
    sentencePL[3] = "Kto pyta ten nie błądzi";
    sentencePL[4] = "Lepiej późno niż wcale";
    sentencePL[5] = "Masz babo placek";
    sentencePL[6] = "Nadzieja umiera ostatnia";
    sentencePL[7] = "Nauka nie poszła w las";
    sentencePL[8] = "Nie szata zdobi człowieka";
    sentencePL[9] = "Pasuje jak piąte koło u wozu";
    var mySentence = sentencePL[Math.floor(Math.random() * 10)];
    return mySentence;
}

function sentenceEnglish() {
    var sentenceEN = new Array(10);
    sentenceEN[0] = "A lie has no legs";
    sentenceEN[1] = "All roads lead to Rome";
    sentenceEN[2] = "Every cloud has a silver lining";
    sentenceEN[3] = "He who excuses himself accuses himself";
    sentenceEN[4] = "Truth is stranger than fiction";
    sentenceEN[5] = "My house is my castle";
    sentenceEN[6] = "It is never late to learn";
    sentenceEN[7] = "It never rains but it pours";
    sentenceEN[8] = "Curiosity killed the cat";
    sentenceEN[9] = "A bad excuse is better than none";
    var mySentence = sentenceEN[Math.floor(Math.random() * 10)];
    return mySentence;
}

var myMainSentence;
var language = document.getElementById("language");
var strUser = language.options[language.selectedIndex].value;

if (strUser == "PL") {
    myMainSentence = sentencePolish();

    var letter = new Array(35);

    letter[0] = "A";
    letter[1] = "Ą";
    letter[2] = "B";
    letter[3] = "C";
    letter[4] = "Ć";
    letter[5] = "D";
    letter[6] = "E";
    letter[7] = "Ę";
    letter[8] = "F";
    letter[9] = "G";
    letter[10] = "H";
    letter[11] = "I";
    letter[12] = "J";
    letter[13] = "K";
    letter[14] = "L";
    letter[15] = "Ł";
    letter[16] = "M";
    letter[17] = "N";
    letter[18] = "Ń";
    letter[19] = "O";
    letter[20] = "Ó";
    letter[21] = "P";
    letter[22] = "Q";
    letter[23] = "R";
    letter[24] = "S";
    letter[25] = "Ś";
    letter[26] = "T";
    letter[27] = "U";
    letter[28] = "V";
    letter[29] = "W";
    letter[30] = "X";
    letter[31] = "Y";
    letter[32] = "Z";
    letter[33] = "Ż";
    letter[34] = "Ź";

}
else if (strUser == "EN") {
    myMainSentence = sentenceEnglish()

    var letter = new Array(26);

    letter[0] = "A";
    letter[1] = "B";
    letter[2] = "C";
    letter[3] = "D";
    letter[4] = "E";
    letter[5] = "F";
    letter[6] = "G";
    letter[7] = "H";
    letter[8] = "I";
    letter[9] = "J";
    letter[10] = "K";
    letter[11] = "L";
    letter[12] = "M";
    letter[13] = "N";
    letter[14] = "O";
    letter[15] = "P";
    letter[16] = "Q";
    letter[17] = "R";
    letter[18] = "S";
    letter[19] = "T";
    letter[20] = "U";
    letter[21] = "V";
    letter[22] = "W";
    letter[23] = "X";
    letter[24] = "Y";
    letter[25] = "Z";

}

myMainSentence = myMainSentence.toUpperCase();

var length = myMainSentence.length;
var wrongChoice = 0;
var points = 0;
var score = 0;

var yes = new Audio("../resources/audio/yes.wav");
var no = new Audio("../resources/audio/no.wav");

var myMainSentenceHidden = "";

for (i = 0; i < length; i++) {
    if (myMainSentence.charAt(i) == " ") myMainSentenceHidden = myMainSentenceHidden + " ";
    else myMainSentenceHidden = myMainSentenceHidden + "-";
}

function writeSentence() {
    document.getElementById("gameBoard").innerHTML = myMainSentenceHidden;
}

window.onload = start;


function start() {

    var divContent = "";

    if (strUser == "PL") {
        for (i = 0; i <= 34; i++) {
            var element = "lit" + i;
            divContent = divContent + '<div class="letter" onclick="check(' + i + ')" id="' + element + '">' + letter[i] + '</div>';
            if ((i + 1) % 7 == 0) divContent = divContent + '<div style="clear:both;"></div>';
        }
    }
    else if (strUser == "EN") {
        for (i = 0; i <= 25; i++) {
            var element = "lit" + i;
            divContent = divContent + '<div class="letter" onclick="check(' + i + ')" id="' + element + '">' + letter[i] + '</div>';
            if ((i + 1) % 6 == 0) divContent = divContent + '<div style="clear:both;"></div>';
        }
    }


        document.getElementById("gameAlphabet").innerHTML = divContent;


    writeSentence();
}

String.prototype.setMySign = function (myPlace, mySign) {
    if (myPlace > this.length - 1) return this.toString();
    else return this.substr(0, myPlace) + mySign + this.substr(myPlace + 1);
}


function check(number) {

    var success = false;

    for (i = 0; i < length; i++) {
        if (myMainSentence.charAt(i) == letter[number]) {
            myMainSentenceHidden = myMainSentenceHidden.setMySign(i, letter[number]);
            success = true;
        }
    }

    if (success == true) {
        yes.play();
        var element = "lit" + number;
        document.getElementById(element).style.background = "#003300";
        document.getElementById(element).style.color = "#00C000";
        document.getElementById(element).style.border = "3px solid #00C000";
        document.getElementById(element).style.cursor = "default";
        points = points + (9 - wrongChoice);
        writeSentence();
    }
    else {
        no.play();
        var element = "lit" + number;
        document.getElementById(element).style.background = "#330000";
        document.getElementById(element).style.color = "#C00000";
        document.getElementById(element).style.border = "3px solid #C00000";
        document.getElementById(element).style.cursor = "default";
        document.getElementById(element).setAttribute("onclick", ";");


        wrongChoice++;
        var photo = "../resources/images/game/s" + wrongChoice + ".png";
        document.getElementById("gameGibbet").innerHTML = '<img src="' + photo + '" alt="" />';
    }

    if (strUser == "PL") {
        //win
        if (myMainSentence == myMainSentenceHidden) {
            document.getElementById("gameAlphabet").innerHTML = "Tak jest! Podano prawidłowe hasło: " + myMainSentence + '<br />' + "Zdobyłeś: " + points + "punktów!" + '<br /><br /><span class="reset" onclick="location.reload()">JESZCZE RAZ</span>';
            score = points;
            document.getElementById("passScore").innerHTML = '<form action="/saveScore.do" method="post">Zapisz wynik: <input type="submit" value="'+score+'" name="userScore" /></form>';
        }
        //lost
        if (wrongChoice >= 9) {
            document.getElementById("gameAlphabet").innerHTML = "Przegrana! Prawidłowe hasło: " + myMainSentence + '<br /><br /><span class="reset" onclick="location.reload()">JESZCZE RAZ</span>';
            score = 0;
        }
    }
    else if (strUser == "EN") {
        //win
        if (myMainSentence == myMainSentenceHidden) {
            document.getElementById("gameAlphabet").innerHTML = "Excellent! You guessed the sentence: " + myMainSentence + '<br />' + "Your points: " + points + "." + '<br /><br /><span class="reset" onclick="location.reload()">TRY AGAIN</span>';
            score = points;
            document.getElementById("passScore").innerHTML = '<form action="/saveScore.do" method="post">Save score: <input type="submit" value="'+score+'" name="userScore" /></form>';

        }
        //lost
        if (wrongChoice >= 9) {
            document.getElementById("gameAlphabet").innerHTML = "You lost! The correct sentence is: " + myMainSentence + '<br /><br /><span class="reset" onclick="location.reload()">TRY AGAIN</span>';
            score = 0;
        }
    }



}
