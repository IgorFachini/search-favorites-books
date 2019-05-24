import { UPDATE_USER } from '../actions/actionTypes'

export const userData = value => ({
    type: UPDATE_USER,
    user: value
  });
  