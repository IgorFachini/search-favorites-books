import { UPDATE_USER } from '../actions/actionTypes'


const initialState = {
    user: ''
};
export const dataReducer = (state = initialState, action) => {
    switch (action.type) {
        case UPDATE_USER:
            return {
                ...state,
                user: action.user
            };
        default:
            return state;
    }
};