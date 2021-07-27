import './HomePage.css'
import TextField from '@material-ui/core/TextField';
import { makeStyles } from "@material-ui/core/styles";
import { useState } from 'react'
import { Results } from '../results/Results';


const useStyles = makeStyles({
  root: {
    "& .MuiOutlinedInput-root .MuiOutlinedInput-notchedOutline": {
      borderColor: "white"
    },
    "&:hover .MuiOutlinedInput-root .MuiOutlinedInput-notchedOutline": {
      borderColor: "white"
    },
    "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
      borderColor: "white"
    },
    "& .MuiInputBase-root": {
      color: "white",
      height: 60
    }
  }
});

export const HomePage = () => {
  const classes = useStyles();

  const [submitted, setSubmitted] = useState(false);

  const handleSubmit = (event) => {
    event.preventDefault();
    setSubmitted(true);
  }

  const [value, setValue] = useState("");

  const handleChange = (event) => {
    setValue(event.target.value);
    setSubmitted(false);
  };

  return (
    <>
      <div className='centered'>
        <h1 className='white-text'> Calculate new saving goal! </h1>
      </div>
      <div className='centered'>
        <h4 className='white-text'>Please provide an api key for this request:</h4>
      </div>
      <div className='centered'>
        <form noValidate autoComplete="off" onSubmit={handleSubmit}>
          <TextField
            id="standard-basic"
            label="ApiKey..."
            variant="outlined"
            className={classes.root}
            InputLabelProps={{
              style: { color: '#FFFFFF' },
            }}
            value={value}
            onChange={handleChange}
          />
        </form>
      </div>
      {submitted && <Results apiKey={value} />}
    </>
  )
}