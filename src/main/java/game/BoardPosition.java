/*
 * Copyright 2017 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package game;

public class BoardPosition {

    private int row_pos;
    private int col_pos;
    private char marker;


    public BoardPosition(int row_pos, int col_pos, char player_marker){
        this.row_pos = row_pos;
        this.col_pos = col_pos;
        this.marker= player_marker;
    }

    /**@requires [row_pos has a value]
    **@ensures getRow = row_pos;
    */
    public int getRow(){
        return row_pos;
    }

    /**@requires [col_pos has a value]
     * @ensures getColumn = col_pos;
     * @return
     */
    public int getColumn(){
        return col_pos;
    }

    /**@requires [marker == x || marker == o]
     * @ensures getMarker = marker
     * @return
     */
    public char getMarker(){
        return marker
    }

    public void setMarker(char marker) {
        this.marker = marker;
    }
}

//For every Board Position we will either have a space, X, or O
