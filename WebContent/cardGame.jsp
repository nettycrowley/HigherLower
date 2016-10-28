<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.rc.cards.Deck, com.rc.cards.Card"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Deck deck;
	Integer score;
	Card current = null;
	Card last = null;
	boolean gameOver = false;
	
	if (request.getParameter("reset") != null){
		
		// remove session variable
		session.removeAttribute("deck");
		session.removeAttribute("score");
	}
	
	if (session.getAttribute("deck")== null) {
		//deck isn't in the session therefore this is the first time
		//create deck
		deck = new Deck();
		
		//shuffle it
		deck.shuffle(10000);
		
		//initialise current card
		//currentCard = 0;
		current = deck.getCurrentCard();
		
		//initialise score
		score = 0;
		
		//store in session object
		session.setAttribute("deck", deck);
		session.setAttribute("score", score);
	} else {
		//read deck from session
		deck = (Deck)session.getAttribute("deck");
			
		//read score from session
		score = (Integer)session.getAttribute("score");
		
		//what did the user say higher or lower
		boolean higher;
		if (request.getParameter("higher") != null){
			higher = true;
		}else{
			higher = false;
		}
		
		//what was the last card
		last = deck.getCurrentCard();
		
		//increment current card
		current = deck.getNextCard();
		
		if ( current == null) {
			//we have run out of cards so the game is over
			gameOver = true;
			
		} else {
				
			//were they right or wrong
			if (current.compare(last) == 0){
				//do nothing
			}else if (higher && current.compare(last) == 1){
				score = score + 1;
			} else if (higher == false && current.compare(last) == -1){
				score = score + 1;
			}	else {
				score = score -1;
			}
				
		//store current card and score in session
		session.setAttribute("score", score);
		session.setAttribute("deck", deck);
		}
	}
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/cards.css" type="text/css">
</head>
<body>

<h1>Higher Lower</h1>

<p>Score: <%=score %> &nbsp; Remaining cards:<%=deck.getRemainingCards() %></p>


<form action="cardGame.jsp" method ="get">
<div id="cardTable">
<% if (gameOver) {%>
	<h1>GAME OVER</h1>
<%
} else {
%>
	<% if (last == null){ %>
		<%=current.displayAsImage() %> <br>
	<% } else { %>
		<%=current.displayAsImage() %> <br>
		<%=last.displayAsImage() %>
	<% } %>
<%} %>
</div>
<br>
	<input type ="submit" name = "higher" value = "higher">
	<input type = "submit" name = "lower" value = "lower">

<br>

	<input type = "submit" name = "reset" value = "reset">


</form>

</body>
</html>