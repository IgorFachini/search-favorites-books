import { dataReducer } from './dataReducer';
import { combineReducers } from 'redux';
export const Reducers = combineReducers({
    dataReducer: dataReducer
});