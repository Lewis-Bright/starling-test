import './Results.css'
import axios from 'axios';
import { useEffect, useState } from 'react'
import CircularProgress from '@material-ui/core/CircularProgress';

export const Results = (props) => {
  const [queryStatus, setQueryStatus] = useState("LOADING");
  const [data, setData] = useState();
  const [error, setError] = useState();

  useEffect(() => {
    const headers = {
      headers: {
        'Content-Type': 'application/json',
        'Authorization': props.apiKey,
      }
    }
    axios.post('http://localhost:8080/savings_goal/create', {}, headers)
      .then(function (response) {
        setData(response.data);
        setQueryStatus("SUCCESS");
      })
      .catch(function (error) {
        setError(error);
        setQueryStatus("ERROR");
      })
  }, [props.apiKey]);

  if (queryStatus === 'LOADING') return (
    <div className='centered gap'>
      <CircularProgress color='secondary' />
    </div>
  )

  if (queryStatus === 'ERROR') return (
    <>
      <div className='centered'>
        <h1>An error has occurred:</h1 >
      </div>
      {error &&
        <div className='centered'>
          <h4 >{error.message}</h4>
        </div>
      }
    </>
  )

  return (<>{data && <h1>You've saved £{data.totalSavings}</h1>}</>)
};