import React from "react";
import { withStyles } from "@material-ui/core/styles";
import Paper from '@material-ui/core/Paper';
import InputBase from '@material-ui/core/InputBase';
import IconButton from '@material-ui/core/IconButton';
import SearchIcon from '@material-ui/icons/Search';
import Grid from '@material-ui/core/Grid';

const styles = theme => ({
  root: {
    margin: 15,
    padding: '2px 4px',
    display: 'flex',
    alignItems: 'center',
    width: 400,
  },
  input: {
    marginLeft: 8,
    flex: 1,
  },
  iconButton: {
    padding: 10,
  }
});

class SearchForm extends React.Component {
  render() {
    const { classes } = this.props;

    return (
      <div id="searchContainer">
        <Grid justify="center" container>
          <Paper className={classes.root}>
            <InputBase type="text" name="bookInput" id="bookInput" form="bookSearch" onChange={(e) => this.props.handleChange(e)} placeholder="Search" required className={classes.input} />
            <IconButton type="submit" onClick={(e) => this.props.handleSearchClick(e)} className={classes.iconButton} aria-label="Search">
              <SearchIcon />
            </IconButton>
          </Paper>
        </Grid>
      </div>

    );
  }
}

export default withStyles(styles)(SearchForm);
