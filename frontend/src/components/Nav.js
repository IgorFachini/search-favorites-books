import React from "react";
import { Link } from "react-router-dom";
import { AppBar, Toolbar, Button } from '@material-ui/core';
import { GoogleLogin, GoogleLogout } from 'react-google-login';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { userData } from '../actions';

const clientId = '13537227901-j1cln2faq0pa3hcr5nd88j1k6jq1fur0.apps.googleusercontent.com'

class Nav extends React.Component {

  constructor() {
    super();
    this.responseGoogle = this.responseGoogle.bind(this);
  }

  componentDidMount() {
    let userData = localStorage.getItem('user')
    if (userData) {
      this.props.userData(userData)
    }
  }

  responseGoogle(response = {}) {
    if (response.profileObj) {
      localStorage.setItem('user', response.profileObj)
      this.props.userData(JSON.stringify(response.profileObj))
    } else {
      localStorage.removeItem('user')
      this.props.userData(null)
    }
  }

  render() {
    const { user } = this.props;

    return (

      <AppBar position="static">
        <Toolbar>
          <h2>Books</h2>
          <Button>
            <Link className="nav-link" to="/">Procurar</Link>
          </Button>
          {user ?
            <Button>
              <Link className="nav-link" to="/saved">Meus Favoritos</Link>
            </Button>
            : null}
          {!user ?
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
    );
  }
}

const mapStateToProps = store => ({
  user: store.dataReducer.user
});

const mapDispatchToProps = dispatch =>
  bindActionCreators({ userData }, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(Nav);
