import './HomePage.css'
import TextField from '@material-ui/core/TextField';
import styled from "styled-components";

const WhiteBorderTextField = styled(TextField)`
  & .MuiOutlinedInput-root .MuiOutlinedInput-notchedOutline {
    border-color: white
  }
  & .MuiOutlinedInput-input {
    color: white
  }
  & .MuiOutlinedInput-root {
    &.Mui-focused fieldset {
      border-color: white
    }
  }
`;

export const HomePage = () => {

  return (
    <>
      <div className='centered'>
        <h1 className='white-text'> Calculate new saving goal! </h1>
      </div>
      <div className='centered'>
        <h4 className='white-text'>Please provide an api key for this request:</h4>
      </div>
      <div className='centered'>
        <form noValidate autoComplete="off">
          <WhiteBorderTextField
            id="standard-basic"
            label="ApiKey"
            variant="outlined"
            key="Confirmation Code"
            InputLabelProps={{
              style: { color: '#A0A0C0' },
            }}
          />
        </form>
      </div>
    </>
  )
}