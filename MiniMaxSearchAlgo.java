package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
	int re=	maxValue(node);
		node.setValue(re);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		// Enter your code here
		if(node.isTerminal()) {
			return node.getValue();
		}
		int re=Integer.MIN_VALUE;
		List<Node>children=node.getChildren();
		for (Node child : children) {
			re=Math.max(re, minValue(child));
		}
		return re;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if(node.isTerminal()) {
			return node.getValue();
		}
		int re=Integer.MAX_VALUE;
		List<Node>children=node.getChildren();
		for (Node child : children) {
			re=Math.min(re, maxValue(child));
		}
		return re;
	}
	}

