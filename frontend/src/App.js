import '@material-ui/styles' // <-- Here

import React, { Component } from 'react';
import './App.css';
import { GoogleLogin, GoogleLogout } from 'react-google-login';
import { AppBar, Toolbar, Button, InputBase } from '@material-ui/core';
import SearchIcon from '@material-ui/icons/Search';
import { fade } from '@material-ui/core/styles/colorManipulator';

import { withStyles } from "@material-ui/core/styles";
import axios from 'axios';

const clientId = '13537227901-j1cln2faq0pa3hcr5nd88j1k6jq1fur0.apps.googleusercontent.com'

const styles = theme => ({
  root: {
    flexGrow: 1,
  },
  search: {
    position: 'relative',
    borderRadius: theme.shape.borderRadius,
    backgroundColor: fade(theme.palette.common.white, 0.15),
    '&:hover': {
      backgroundColor: fade(theme.palette.common.white, 0.25),
    },
    marginRight: theme.spacing.unit * 2,
    marginLeft: 0,
    width: '100%',
    [theme.breakpoints.up('sm')]: {
      marginLeft: theme.spacing.unit * 3,
      width: 'auto',
    },
  },
  searchIcon: {
    width: theme.spacing.unit * 9,
    position: 'absolute',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  },
  inputRoot: {
    color: 'inherit',
    width: '100%',
  },
  inputInput: {
    paddingTop: theme.spacing.unit,
    paddingRight: theme.spacing.unit,
    paddingBottom: theme.spacing.unit,
    paddingLeft: theme.spacing.unit * 10,
    transition: theme.transitions.create('width'),
    width: '100%',
    [theme.breakpoints.up('md')]: {
      width: 200,
    },
  },
});

class App extends Component {
  constructor() {
    super();
    this.state = {
      user: null,
      search: ''
    }
    this.responseGoogle = this.responseGoogle.bind(this);
    this.search = this.search.bind(this);
  }

  handleChange = name => event => {
    this.setState({ [name]: event.target.value });
  };

  responseGoogle(response = {}) {
    console.log(response);
    if (response.profileObj) {
      this.setState( { user: response.profileObj })
    } else {
      this.setState( { user: null } )
    }
  }

  search() {
    console.log(this.state.search)
    axios.get(`http://localhost:8082/searchBooks?query=${this.state.search}`)
    .then(res => {
      console.log(res)
    })
  }

  render() {
    const { classes } = this.props;

    return (
      <div className={classes.root}>
        <AppBar position="static">
          <Toolbar>
          {!this.state.user ? 
          <GoogleLogin
            clientId={clientId}
            buttonText="Login"
            onSuccess={this.responseGoogle}
            onFailure={this.responseGoogle}
            cookiePolicy={'single_host_origin'}
          />
          :
          <GoogleLogout
            buttonText="Logout"
            clientId={clientId}
            onLogoutSuccess={this.responseGoogle}
          />
          }
          </Toolbar>
          
        </AppBar>
        <div className={classes.search}>
          <div className={classes.searchIcon}>
            <Button onClick={this.search} variant="contained" color="secondary">
                <SearchIcon />
            </Button>
          </div>
          <InputBase
            placeholder="Search…"
            value={this.state.search}
            onChange={this.handleChange('search')}
            classes={{
              root: classes.inputRoot,
              input: classes.inputInput,
            }}
          />
        </div>
      </div>
    );
  }
}

export default withStyles(styles)(App);
