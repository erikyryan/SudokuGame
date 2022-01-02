package com.sudoku.buildlogic;

import com.sudoku.computationlogic.GameLogic;
import com.sudoku.domain.IStorage;
import com.sudoku.domain.SudokuGame;
import com.sudoku.persistence.LocalStorageImpl;
import com.sudoku.userinterface.IUserInterfaceContract;
import com.sudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userinterface) throws IOException {
        SudokuGame initialState;

        IStorage storage = new LocalStorageImpl();

        try{
            initialState = storage.getGameData();

        }catch(IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage,userinterface);

        userinterface.setListener(uiLogic);
        userinterface.updateBoard(initialState);
    }
}
